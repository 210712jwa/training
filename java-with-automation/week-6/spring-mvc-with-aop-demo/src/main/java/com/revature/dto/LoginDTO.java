package com.revature.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @ToString
public class LoginDTO {

	private String username;
	private String password;
	
	public LoginDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
