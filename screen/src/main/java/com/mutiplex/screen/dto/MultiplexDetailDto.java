package com.mutiplex.screen.dto;

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
public class MultiplexDetailDto {
	private String multiplexId;
	private String multiplexName;
	private String address;
	private Integer numberOfScreens;
	private List<String> screenLists;
}
