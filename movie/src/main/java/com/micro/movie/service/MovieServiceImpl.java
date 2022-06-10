package com.micro.movie.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import com.micro.movie.dao.MovieRepository;
import com.micro.movie.document.MovieDetail;
import com.micro.movie.dto.AddMovieDto;
import com.micro.movie.dto.MovieDetailDto;
import com.micro.movie.dto.UpdateMovieDto;





@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepository;
	
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	//ADD A MOVIE
	@Override
	public MovieDetailDto addMovie(AddMovieDto addMovieDto) {
		MovieDetail movieDetail = new MovieDetail(null, 
				   addMovieDto.getMovieName(),
				   addMovieDto.getCategory(), 
				   addMovieDto.getProducer(),
				   addMovieDto.getDirector(),
				   addMovieDto.getReleaseDate(),
				   addMovieDto.getPhotoPath());
				
		movieDetail = this.movieRepository.save(movieDetail);
     // convert Document->Dto
     MovieDetailDto  movieDetailDto = new MovieDetailDto (movieDetail.getMovieId(), 
		movieDetail.getMovieName(), 
		movieDetail.getCategory(), 
		movieDetail.getProducer(),
		movieDetail.getDirector(),
		movieDetail.getReleaseDate(),
		movieDetail.getPhotoPath());
		
     return movieDetailDto;
	}
	
    //GET ALL MOVIES
	@Override
	public List<MovieDetail> getAllMovies() {
		List<MovieDetail> getAllMovies=(List<MovieDetail>) this.movieRepository.findAll();
		return getAllMovies;
	}
	
    //GET A MOVIE FOR PARTICULAR ID
	@Override
	public MovieDetailDto getMovieDetail(String movieId) {
		MovieDetail movieDetail =  this.movieRepository.findById(movieId).orElse(null);
		if(movieDetail != null) {
			MovieDetailDto movieDetailDto= new MovieDetailDto(movieDetail.getMovieId(), 
					movieDetail.getMovieName(), 
					movieDetail.getCategory(), 
					movieDetail.getProducer(),
					movieDetail.getDirector(),
					movieDetail.getReleaseDate(),
					movieDetail.getPhotoPath());
				
			return movieDetailDto;
		}
		return null;
	}
	
   //DELETE A MOVIE
	@Override
	public void deleteMovie(String movieId) {
		MovieDetail movieDetail =  this.movieRepository.findById(movieId).orElse(null);
		if(movieDetail != null) {
			movieRepository.deleteById(movieId);
			}
	}
	
    //UPDATE A MOVIE
	@Override
	public MovieDetailDto updateMovieDetail(String movieId, UpdateMovieDto updateMovieDto) {
		MovieDetail movieDetail =  this.movieRepository.findById(movieId).orElse(null);
		if(movieDetail != null) {
			movieDetail.setMovieId(movieId);
			movieDetail.setMovieName(updateMovieDto.getMovieName());
			movieDetail.setCategory(updateMovieDto.getCategory());
			movieDetail.setProducer(updateMovieDto.getProducer());
			movieDetail.setDirector(updateMovieDto.getDirector());
			movieDetail.setReleaseDate(updateMovieDto.getReleaseDate());
			movieDetail.setPhotoPath(updateMovieDto.getPhotoPath());
			
			movieDetail = this.movieRepository.save(movieDetail);
			MovieDetailDto  movieDetailDto = new MovieDetailDto (movieDetail.getMovieId(), 
					  movieDetail.getMovieName(),
					  movieDetail.getCategory(),
					  movieDetail.getProducer(),
					  movieDetail.getDirector(),
			          movieDetail.getReleaseDate(),
			          movieDetail.getPhotoPath());
				      return movieDetailDto;
		}
		return null;
	}
	

}
