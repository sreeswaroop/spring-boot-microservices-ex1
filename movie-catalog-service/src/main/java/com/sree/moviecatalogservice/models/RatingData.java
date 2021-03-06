package com.sree.moviecatalogservice.models;

public class RatingData {

	private String movieId;
	private int rating;
	
	public RatingData() {
		
	}
	public RatingData(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "RatingData [movieId=" + movieId + ", rating=" + rating + "]";
	}
	
}
