package com.bridgelabz.app.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class ResponseDTO {
	private String message;
	private Object data;
	
	
	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	
}
