package com.fpt.soft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fpt.soft.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
