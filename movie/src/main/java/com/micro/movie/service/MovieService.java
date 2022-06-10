package com.micro.movie.service;

import java.util.List;
import java.util.Locale.Category;

import com.micro.movie.document.MovieDetail;
import com.micro.movie.dto.AddMovieDto;
import com.micro.movie.dto.MovieDetailDto;
import com.micro.movie.dto.UpdateMovieDto;

public interface MovieService {
	public MovieDetailDto addMovie(AddMovieDto addMovieDto);
	public List<MovieDetail> getAllMovies();
	public MovieDetailDto getMovieDetail(String movieId);
	public void deleteMovie(String movieId);
	public MovieDetailDto updateMovieDetail(String movieId,UpdateMovieDto updateMovieDto);
	
}
