package com.micro.multiplex.dto;

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
public class AddAllotmentDto {
	private String movieId;
	private String multiplexId;
	private String screenId;
}
