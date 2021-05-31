package com.fpt.soft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.soft.model.Booking;
import com.fpt.soft.repository.BookingRepository;
import com.fpt.soft.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;

	public Booking save(Booking entity) {
		return bookingRepository.save(entity);
	}

	public <S extends Booking> Iterable<S> saveAll(Iterable<S> entities) {
		return bookingRepository.saveAll(entities);
	}

	public Optional<Booking> findById(Integer id) {
		return bookingRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return bookingRepository.existsById(id);
	}

	public List<Booking> findAll() {
		return (List<Booking>) bookingRepository.findAll();
	}

	public Iterable<Booking> findAllById(Iterable<Integer> ids) {
		return bookingRepository.findAllById(ids);
	}

	public long count() {
		return bookingRepository.count();
	}

	public void deleteById(Integer id) {
		bookingRepository.deleteById(id);
	}

	public void delete(Booking entity) {
		bookingRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Booking> entities) {
		bookingRepository.deleteAll(entities);
	}

	public void deleteAll() {
		bookingRepository.deleteAll();
	}
	
}
