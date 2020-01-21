package com.sree.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sree.ratingsdataservice.models.RatingData;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

	@RequestMapping("/{movieId}")
	public RatingData getMovieRating(@PathVariable("movieId") String id) {
		return new RatingData(id, 4);
	}
}
