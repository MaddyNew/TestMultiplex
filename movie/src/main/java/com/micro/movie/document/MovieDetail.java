package com.micro.movie.document;
import java.time.LocalDateTime;
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
public class MovieDetail {

		
		
	    @Id
		private String movieId;
		private String movieName;
		private String category;
		private String producer;
		private String director;
		private LocalDateTime releaseDate;
		private String photoPath;
}
