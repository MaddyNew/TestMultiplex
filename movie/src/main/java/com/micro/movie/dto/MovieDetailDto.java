package com.micro.movie.dto;

import java.time.LocalDateTime;

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
public class MovieDetailDto {
	private String movieId;
	private String movieName;
	private String category;
	private String producer;
	private String director;
	private LocalDateTime releaseDate;
	private String photoPath;
}
