package com.micro.movie.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.micro.movie.document.MovieDetail;


@Repository
public interface MovieRepository extends MongoRepository<MovieDetail, String> {

}
