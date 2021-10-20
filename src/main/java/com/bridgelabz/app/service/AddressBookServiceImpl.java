package com.bridgelabz.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.dto.AddressLoginDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.exceptionhandler.ABSException;
import com.bridgelabz.app.model.AddressData;
import com.bridgelabz.app.model.AddressLogin;
import com.bridgelabz.app.repository.IAddressBookLogin;
import com.bridgelabz.app.repository.IAddressBookRepository;

@Service
public class AddressBookServiceImpl implements AddressBookService {
	List<AddressData> datas = new ArrayList<AddressData>();

	private static AtomicLong atomicLong = new AtomicLong();

	@Autowired
	private IAddressBookRepository addressBookRepository;
	
	@Autowired
	private IAddressBookLogin loginData; 

	/**
	 * inserting data to list.
	 */
	@Override
	public ResponseDTO create(AddressDTO e) {
		AddressData data = new AddressData(atomicLong.incrementAndGet(), e);
		ResponseDTO dto = new ResponseDTO("post call success", data);
		addressBookRepository.save(data);
		return dto;
	}

	/**
	 * fetching all data from list.
	 */
	@Override
	public ResponseDTO readAll() {
		ResponseDTO dto = new ResponseDTO("get call success", addressBookRepository.findAll());
		return dto;
	}

	/**
	 * fetching data by id from list.
	 */
	@Override
	public ResponseDTO getDataById(int id) {
		List<AddressData> data = addressBookRepository.findAll();
		Optional<AddressData> getAddress = data.stream().filter(e -> e.getId() == id).findFirst();
		if (getAddress.isPresent()) {
			ResponseDTO dto = new ResponseDTO("getById call success", getAddress);
			return dto;
		} else {
			throw new ABSException("data not found for id ->" + id);

		}

	}

	/**
	 * updating data from list by id.
	 */
	@Override
	public ResponseDTO updateDataById(int id, AddressDTO dto) {

		List<AddressData> data = addressBookRepository.findAll();
		Optional<AddressData> getAddress = data.stream().filter(e -> e.getId() == id).findFirst();
		if (getAddress.isPresent()) {
			AddressData addressData = data.stream().filter(e -> e.getId() == id).findFirst().get();

			addressData.setName(dto.getName());
			addressData.setAddress(dto.getAddress());
			addressData.setPin(dto.getPin());
			addressData.setCityName(dto.getCityName());
			addressData.setStateName(dto.getStateName());
			addressData.setPhoneNumber(dto.getPhoneNumber());
			addressData.setEmailAddress(dto.getEmailAddress());
			addressBookRepository.save(addressData);
			ResponseDTO responseDto = new ResponseDTO("put call success", addressData);
			return responseDto;
		} else {
			throw new ABSException(id + " <- id not found to update data");

		}

	}

	/**
	 * deleting data from list using id.
	 */
	@Override
	public ResponseDTO deleteDataById(int id) {

		List<AddressData> data = addressBookRepository.findAll();
		Optional<AddressData> getAddress = data.stream().filter(e -> e.getId() == id).findFirst();
		if (getAddress.isPresent()) {
			AddressData addressData = data.stream().filter(e -> e.getId() == id).findFirst().get();
			addressBookRepository.delete(addressData);
			ResponseDTO dto = new ResponseDTO("delete call success", getAddress);
			return dto;
		} else {
			throw new ABSException(id + " <- id not found to delete data");

		}
	}

	@Override
	public ResponseDTO login(AddressLoginDTO e) {
		AddressLogin data=new AddressLogin(e.getUserName(),e.getPassword(),e.getEmail());
		loginData.save(data);
		ResponseDTO dto=new ResponseDTO("posting login data",data);
		return dto;
	}

	@Override
	public ResponseDTO getLogins() {
		ResponseDTO dto =new ResponseDTO("getting all login data",loginData.findAll());
		return dto;
	}

	


	
	

}
