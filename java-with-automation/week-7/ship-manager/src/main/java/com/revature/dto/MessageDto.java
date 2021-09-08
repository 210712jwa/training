package com.revature.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @ToString
public class MessageDto {

	private String message;
	
	public MessageDto(String message) {
		this.message = message;
	}
	
}
