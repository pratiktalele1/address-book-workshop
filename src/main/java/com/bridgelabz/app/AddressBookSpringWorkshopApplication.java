package com.bridgelabz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication @Slf4j
public class AddressBookSpringWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookSpringWorkshopApplication.class, args);
		System.out.println("hello from workshop spring boot app.");
		log.info("lombok is added to project..!");
	}

}
