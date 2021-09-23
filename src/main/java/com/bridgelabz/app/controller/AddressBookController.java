package com.bridgelabz.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.model.AddressData;
import com.bridgelabz.app.service.AddressBookService;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/address") @Slf4j
public class AddressBookController {
//	private List<AddressDTO> list=new ArrayList<AddressDTO>();
	
	@Autowired
	private AddressBookService addressBookService;
	
//	private static AtomicLong atomicLong=new AtomicLong();
	
	/**
	 * requesting to fetch all data using get http method
	 * @return list
	 */
	@GetMapping
	private ResponseEntity<ResponseDTO> getAll() {
		log.info("get all data");
		return new ResponseEntity<>(addressBookService.readAll(),HttpStatus.OK);
	}
	
	/**
	 * requseting to insert data using post http method 
	 * @param AddressData
	 * @return response dto
	 */
	@PostMapping
	private ResponseEntity<ResponseDTO> create(@Valid @RequestBody AddressDTO AddressData) {
		log.info("data inserted.");
		return new ResponseEntity<>(addressBookService.create(AddressData),HttpStatus.CREATED);
	}
	
	/**
	 * requseting to get data using id with get http method 
	 * @param id
	 * @return response dto
	 */
	@GetMapping("/{id}")
	private ResponseEntity<ResponseDTO> getById(@PathVariable int id){
		log.info("data is retrived with id ->"+id);
		return new ResponseEntity<>(addressBookService.getDataById(id),HttpStatus.FOUND);
	}
	
	/**
	 * requseting to update data using id with put http method 
	 * @param id
	 * @return response dto
	 */
	@PutMapping("/{id}")
	private ResponseEntity<ResponseDTO> updateById(@PathVariable int id,@RequestBody AddressDTO addressData){
		log.info("data updated with id ->"+id);
		return new ResponseEntity<>(addressBookService.updateDataById(id, addressData),HttpStatus.OK);
	}
	
	/**
	 * requseting to delete data using id with delete http method 
	 * @param id
	 * @return response dto
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<ResponseDTO> deleteById(@PathVariable int id) {
		log.info("data deleted with id ->"+id);
		return new ResponseEntity<>(addressBookService.deleteDataById(id),HttpStatus.OK);
	}

}
