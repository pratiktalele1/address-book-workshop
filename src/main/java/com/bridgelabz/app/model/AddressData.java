package com.bridgelabz.app.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class AddressData {
	private String name;
	private String address;
	private int pin;
	private long id;
}
