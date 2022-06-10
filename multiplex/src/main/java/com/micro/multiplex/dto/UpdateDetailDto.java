package com.micro.multiplex.dto;
import java.util.List;

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
public class UpdateDetailDto {
		private String multiplexName;
		private String address;
		private Integer numberOfScreens;
		private String photoPath;
	
	}

