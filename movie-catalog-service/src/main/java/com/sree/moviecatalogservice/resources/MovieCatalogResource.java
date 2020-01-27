package com.sree.moviecatalogservice.resources;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sree.moviecatalogservice.models.CatalogItem;
import com.sree.moviecatalogservice.models.Movie;
import com.sree.moviecatalogservice.models.RatingData;
import com.sree.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{id}")
	public List<CatalogItem> getCatalog(@PathVariable("id") String userId) {

		// Get all the movie IDs
		UserRating userRating = (UserRating) restTemplate.getForObject("http://localhost:8003/ratingsdata/users/" + userId, UserRating.class);
		
		return userRating.getUserRating().stream().map(rating -> {
			Movie movieObj = restTemplate.getForObject("http://localhost:8002/movies/" + rating.getMovieId(), Movie.class);
			/*
			 * Movie movieObj = webClientBuilder.build().get()
			 * .uri("http://localhost:8002/movies/" + rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			return new CatalogItem(movieObj.getName(), movieObj.getDesc(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
