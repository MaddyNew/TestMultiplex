package com.micro.multiplex.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.micro.multiplex.document.AllotedMovies;



@Repository
public interface AllotedMoviesRepository extends MongoRepository<AllotedMovies, String>{
	List<AllotedMovies> findByMovieId(String movieId);
	List<AllotedMovies> findByMultiplexId(String multiplexId);
}
