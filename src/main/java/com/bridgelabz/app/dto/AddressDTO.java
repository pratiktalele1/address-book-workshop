package com.bridgelabz.app.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class AddressDTO {
	@Pattern(regexp = "[A-Za-z]+", message = "invalid user name")
	private String name;
	@Pattern(regexp = "[A-Za-z]+", message = "invalid address	")
	private String address;
	private int pin;
	private long id;	
	private String cityName;
	private String stateName;
	private String phoneNumber;
	private String emailAddress;

	
}
