package com.mutiplex.screen.dao;

import org.springframework.data.repository.CrudRepository;

import com.mutiplex.screen.document.ScreenDetails;


public interface ScreenServiceRepository extends CrudRepository<ScreenDetails, String>{

}
