package com.bridgelabz.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name="login") 
public @Data class AddressLogin {
	@Id
	private String userName;
	private String password;
	private String email;
	
	public AddressLogin( String userName, String password , String email) {
		// TODO Auto-generated constructor stub
		this.userName=userName;
		this.password=password;
		this.email=email;
	}
	
	public AddressLogin() {
		// TODO Auto-generated constructor stub
	}
}
