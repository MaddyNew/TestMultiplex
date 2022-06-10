package com.micro.multiplex.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;


import com.micro.multiplex.document.ScreenDetail;
@Repository
public interface ScreenRepository  extends MongoRepository<ScreenDetail,String> {
	List<ScreenDetail> findByMultiplexId(String multiplexId);

}
