package com.micro.multiplex.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MultiplexDetail 
	{
	@Id
	private String multiplexId;
	private String multiplexName;
	private String address;
	private Integer numberOfScreens;
	private String photoPath;

}
