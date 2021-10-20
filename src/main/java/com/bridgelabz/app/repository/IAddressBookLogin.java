package com.bridgelabz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.app.dto.AddressLoginDTO;
import com.bridgelabz.app.model.AddressLogin;

public interface IAddressBookLogin extends JpaRepository<AddressLogin, String> {

}
