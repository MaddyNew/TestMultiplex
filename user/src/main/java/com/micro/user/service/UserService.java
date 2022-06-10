package com.micro.user.service;

import com.micro.user.dto.LoginUserDto;
import com.micro.user.dto.RegisterUserDto;
import com.micro.user.dto.UserDetailsDto;

public interface UserService {
	public UserDetailsDto register(RegisterUserDto registerUserDto);
	public UserDetailsDto login(LoginUserDto loginUserDto);
	public boolean checkAlreadyInUse(String emailId);
	public UserDetailsDto getUserDetail(String userId);
}
