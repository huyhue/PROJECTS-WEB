package com.fpt.soft.service;

import java.util.List;
import java.util.Optional;

import com.fpt.soft.model.Booking;

public interface BookingService {
	Booking save(Booking entity);
	Optional<Booking> findById(Integer id);
	List<Booking> findAll();
}
