package com.sree.ratingsdataservice.models;

import java.util.List;

public class UserRating {
	
	private List<RatingData> userRating;

	public List<RatingData> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<RatingData> userRating) {
		this.userRating = userRating;
	}
	
	
}
