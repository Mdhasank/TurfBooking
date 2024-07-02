package com.turf.service;


import java.sql.Date;
import java.util.List;
import com.turf.enities.Booking;

public interface BookingService {
	
	public Booking saveBooking(Booking booking);
	
	public boolean existsBySlotAndDateAndName(String slot,Date date,String name);
	
	public List<Booking> getAllBookings();
			 
}
