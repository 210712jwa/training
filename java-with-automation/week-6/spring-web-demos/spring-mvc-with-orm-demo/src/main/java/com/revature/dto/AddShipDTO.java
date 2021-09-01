package com.revature.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @ToString @NoArgsConstructor
public class AddShipDTO {

	private String name;
	private int age;
	
}
