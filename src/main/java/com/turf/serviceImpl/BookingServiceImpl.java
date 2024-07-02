package com.turf.serviceImpl;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf.enities.Booking;
import com.turf.repository.BookingRepostory;
import com.turf.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepostory bookingRepostory;

	@Override
	public Booking saveBooking(Booking booking) {

		return bookingRepostory.save(booking);
	}

	@Override
	public boolean existsBySlotAndDateAndName(String slot,Date date,String name) {
		
		return bookingRepostory.existsBySlotAndDateAndName(slot,date,name);
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> bookings = bookingRepostory.findAll();
		return bookings;
	}

	
	

	

}
