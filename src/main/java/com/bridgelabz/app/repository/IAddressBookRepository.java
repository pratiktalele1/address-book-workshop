package com.bridgelabz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.app.model.AddressData;

public interface IAddressBookRepository extends JpaRepository<AddressData, Integer> {

}
