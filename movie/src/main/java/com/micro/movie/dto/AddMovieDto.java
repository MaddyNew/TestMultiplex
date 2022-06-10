package com.micro.movie.dto;

import java.time.LocalDateTime;

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
public class AddMovieDto {
	private String movieName;
	private String category;
	private String producer;
	private String director;
	private LocalDateTime releaseDate;
	private String photoPath;
}
