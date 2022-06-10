package com.micro.user.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsDto {
	private String id;
	private String emailId;
	private String firstName;
	private String lastName;
	private String userGroup;
}
