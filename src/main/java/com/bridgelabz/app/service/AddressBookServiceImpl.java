package com.bridgelabz.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.model.AddressData;

@Service
public class AddressBookServiceImpl implements AddressBookService {

	List<AddressData> datas = new ArrayList<AddressData>();

	private static AtomicLong atomicLong = new AtomicLong();

	/**
	 * inserting data to list.
	 */
	@Override
	public ResponseDTO create(AddressDTO e) {
		AddressData data = new AddressData(atomicLong.incrementAndGet(), e);
		ResponseDTO dto = new ResponseDTO("get call success", data);
		datas.add(data);
		return dto;
	}

	/**
	 * fetching all data from list.
	 */
	@Override
	public ResponseDTO readAll() {
		ResponseDTO dto=new ResponseDTO("all data fetch", datas);
		return dto;
	}

	/**
	 * fetching data by id from list.
	 */
	@Override
	public ResponseDTO getDataById(int id) {
		AddressData data = datas.stream().filter(e -> e.getId() == id).findFirst().get();
			ResponseDTO dto = new ResponseDTO("get call success", data);
			return dto;
	}

	/**
	 * updating data from list by id.
	 */
	@Override
	public ResponseDTO updateDataById(int id, AddressDTO dto) {
		AddressData data = datas.stream().filter(e -> e.getId() == id).findFirst().get();
		data.setName(dto.getName());
		data.setAddress(dto.getAddress());
		data.setPin(dto.getPin());
		ResponseDTO responseDto = new ResponseDTO("put call success", data);
		return responseDto;
	}

	/**
	 * deleting data from list using id.
	 */
	@Override
	public ResponseDTO deleteDataById(int id) {
		AddressData data = datas.stream().filter(e -> e.getId() == id).findFirst().get();
		datas.remove(data);
		ResponseDTO dto = new ResponseDTO("delete call success", data);
		return dto;
	}

}
