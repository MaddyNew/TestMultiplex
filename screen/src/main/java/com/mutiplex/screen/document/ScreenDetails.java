package com.mutiplex.screen.document;

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
public class ScreenDetails {
	@Id
	private Integer screenId;
	private String  screenName;
	private String multiplexId;

}
