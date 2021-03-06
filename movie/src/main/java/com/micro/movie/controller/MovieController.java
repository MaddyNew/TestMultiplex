package com.micro.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.movie.document.MovieDetail;
import com.micro.movie.dto.AddMovieDto;
import com.micro.movie.dto.MovieDetailDto;
import com.micro.movie.dto.UpdateMovieDto;
import com.micro.movie.service.MovieService;


@RestController
@RequestMapping("/api/movie")
//@CrossOrigin("*")
public class MovieController {
	
private MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	@PostMapping("/addMovie")
	public ResponseEntity<MovieDetailDto> addMovie(@RequestBody AddMovieDto addMovieDto) {
		MovieDetailDto movieDetailDto = this.movieService.addMovie(addMovieDto);
		ResponseEntity<MovieDetailDto> response = 
				new ResponseEntity<MovieDetailDto>(movieDetailDto ,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<MovieDetail>> getAllMovies() {
		List<MovieDetail> getMovies=this.movieService.getAllMovies();
		ResponseEntity<List<MovieDetail>> response = 
				new ResponseEntity<List<MovieDetail>>(getMovies,HttpStatus.OK);
		return response;
	}
	@GetMapping("/get/{movieId}")
	public ResponseEntity<MovieDetailDto> getMovieDetail(@PathVariable("movieId")String movieId) {
		MovieDetailDto movieDetailDto =  this.movieService.getMovieDetail(movieId);
		// manage user not found exception
		ResponseEntity<MovieDetailDto> response = 
				new ResponseEntity<MovieDetailDto>(movieDetailDto ,HttpStatus.OK);
		return response;
		
	}
	@DeleteMapping("/delete/{movieId}")
	public void deleteMovie(@PathVariable("movieId")String movieId) {

	this.movieService.deleteMovie(movieId);

	}
	
	@PutMapping("/update/{movieId}")
	public ResponseEntity<MovieDetailDto> updateMovieDetail(@PathVariable("movieId")String movieId,@RequestBody UpdateMovieDto updateMovieDto) {
		MovieDetailDto movieDetailDto =this.movieService.updateMovieDetail(movieId,updateMovieDto);
		ResponseEntity<MovieDetailDto> response = 
				new ResponseEntity<MovieDetailDto>(movieDetailDto,HttpStatus.OK);
		return response;
	}

}
