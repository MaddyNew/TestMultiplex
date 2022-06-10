package com.micro.multiplex.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.micro.multiplex.document.MultiplexDetail;
@Repository
public interface MultiplexRepository extends MongoRepository<MultiplexDetail, String> {

}
