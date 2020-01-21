package com.sree.movieInfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sree.movieInfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{id}")
	public Movie getMovieInfo(@PathVariable("id") String movieId) {
		return new Movie(movieId, "Transformer","Transformer description");
	}
}
