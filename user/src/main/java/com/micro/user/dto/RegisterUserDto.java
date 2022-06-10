package com.micro.user.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
	private String emailId;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String userGroup;

}
