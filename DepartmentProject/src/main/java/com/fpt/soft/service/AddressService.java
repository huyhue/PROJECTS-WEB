package com.fpt.soft.service;

import java.util.Optional;

import com.fpt.soft.model.Address;

public interface AddressService {
	public Optional<Address> findById(Integer id);
}
