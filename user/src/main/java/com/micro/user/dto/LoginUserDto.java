package com.micro.user.dto;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
@Data
public class LoginUserDto {
	private String loginId;
	@Length(min = 6)
	private String password;
}
