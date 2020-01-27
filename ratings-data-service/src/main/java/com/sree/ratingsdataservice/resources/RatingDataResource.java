package com.sree.ratingsdataservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sree.ratingsdataservice.models.RatingData;
import com.sree.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

	@RequestMapping("/{movieId}")
	public RatingData getMovieRating(@PathVariable("movieId") String id) {
		return new RatingData(id, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<RatingData> ratings = Arrays.asList(
					new RatingData("1234", 4),
					new RatingData("5467", 3)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
