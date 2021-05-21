package com.fpt.soft.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Address;
import com.fpt.soft.model.Department;
import com.fpt.soft.model.Images;
import com.fpt.soft.repository.AddressRepository;
import com.fpt.soft.repository.DepartmentRepository;
import com.fpt.soft.repository.ImagesRepository;
import com.fpt.soft.service.AddressService;
import com.fpt.soft.service.ImagesService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository imagesRepository;

	public Optional<Address> findById(Integer id) {
		return imagesRepository.findById(id);
	}
	
}
