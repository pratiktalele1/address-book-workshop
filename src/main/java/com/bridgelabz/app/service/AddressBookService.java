package com.bridgelabz.app.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.model.AddressData;


public interface AddressBookService {
	List<AddressData> datas = new ArrayList<AddressData>();

	ResponseDTO create(AddressDTO e);

	ResponseDTO readAll();

	ResponseDTO getDataById(int id);

	ResponseDTO updateDataById(int id, AddressDTO dto);

	ResponseDTO deleteDataById(int id);

}
