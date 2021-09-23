package com.bridgelabz.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class AddressDTO {
	private String name;
	private String address;
	private int pin;
	private long id;
	
}
