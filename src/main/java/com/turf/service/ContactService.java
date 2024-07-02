package com.turf.service;

import java.util.List;

import com.turf.enities.ContactUs;

public interface ContactService {
	
	public ContactUs saveContact(ContactUs contactUs);
	
	public List<ContactUs> getAllContactUs();

}
