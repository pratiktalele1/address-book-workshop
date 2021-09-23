package com.bridgelabz.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.com.bridgelabz.app.AddressDTO;
import org.com.bridgelabz.app.ResponseDTO;
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

import com.bridgelabz.app.model.AddressData;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/address") @Slf4j
public class AddressBookController {
	private List<AddressDTO> list=new ArrayList<AddressDTO>();
	private static AtomicLong atomicLong=new AtomicLong();
	
	/**
	 * requesting to fetch all data using get http method
	 * @return list
	 */
	@GetMapping
	private ResponseEntity<ResponseDTO> getAll() {
		log.info("get all data");
		ResponseDTO dto=new ResponseDTO("get all call successful",list);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	/**
	 * requseting to insert data using post http method 
	 * @param AddressData
	 * @return response dto
	 */
	@PostMapping
	private ResponseEntity<ResponseDTO> create(@RequestBody AddressDTO AddressData) {
		AddressData.setId(atomicLong.incrementAndGet());
		list.add(AddressData);
		ResponseDTO dto=new ResponseDTO("post call successful", AddressData);
		log.info("data inserted.");
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	/**
	 * requseting to get data using id with get http method 
	 * @param id
	 * @return response dto
	 */
	@GetMapping("/{id}")
	private ResponseEntity<ResponseDTO> getById(@PathVariable int id){
		AddressDTO data =list.stream().filter(e->e.getId()==id).findFirst().get();
		ResponseDTO dto=new ResponseDTO("get id call successful", data);
		log.info("data is retrived with id ->"+id);
		return new ResponseEntity<>(dto,HttpStatus.FOUND);
	}
	
	/**
	 * requseting to update data using id with put http method 
	 * @param id
	 * @return response dto
	 */
	@PutMapping("/{id}")
	private ResponseEntity<ResponseDTO> updateById(@PathVariable int id,@RequestBody AddressDTO addressData){
		AddressDTO updateData=list.stream().filter(e->e.getId()==id).findFirst().get();
		updateData.setName(addressData.getName());
		updateData.setAddress(addressData.getAddress());
		updateData.setPin(addressData.getPin());
		ResponseDTO dto=new ResponseDTO("put call successful", updateData);
		log.info("data updated with id ->"+id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	/**
	 * requseting to delete data using id with delete http method 
	 * @param id
	 * @return response dto
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<ResponseDTO> deleteById(@PathVariable int id) {
		AddressDTO addressData=list.stream().filter(e->e.getId()==id).findFirst().get();
		list.remove(addressData);
		ResponseDTO dto=new ResponseDTO("delete call successful", addressData);
		log.info("data deleted with id ->"+id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}

}
