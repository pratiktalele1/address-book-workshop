package com.bridgelabz.app.model;

import com.bridgelabz.app.dto.AddressDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class AddressData {
	private String name;
	private String address;
	private int pin;
	private long id;
	
	public AddressData(long id,AddressDTO addressDTO) {
		this.id=id;
		this.name=addressDTO.getName();
		this.pin=addressDTO.getPin();
		this.address=addressDTO.getAddress();
	}
	
	
}
