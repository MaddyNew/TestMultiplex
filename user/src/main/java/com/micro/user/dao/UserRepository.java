package com.micro.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.micro.user.document.UserDetail;
@Repository
public interface UserRepository extends CrudRepository<UserDetail, String>{
	List<UserDetail> findByEmailIdAndPassword(String emailId, String password);
	List<UserDetail> findByEmailId(String emailId);
}
