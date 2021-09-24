package com.bridgelabz.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.app.dto.AddressDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Entity @Table(name = "addressdata")
public @Data class AddressData {
	private String name;
	private String address;
	private int pin;
	@Id
	private long id;
	private String cityName;
	private String stateName;
	private String phoneNumber;
	private String emailAddress;
	
	public AddressData() {
		
	}
	
	public AddressData(long id,AddressDTO addressDTO) {
		this.id=id;
		this.name=addressDTO.getName();
		this.pin=addressDTO.getPin();
		this.address=addressDTO.getAddress();
		this.cityName=addressDTO.getCityName();
		this.stateName=addressDTO.getStateName();
		this.phoneNumber=addressDTO.getPhoneNumber();
		this.emailAddress=addressDTO.getEmailAddress();
	}
	
	
}
