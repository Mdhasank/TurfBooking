package com.turf.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf.enities.ContactUs;
import com.turf.repository.ContactRepo;
import com.turf.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;	
	
	
	@Override
	public ContactUs saveContact(ContactUs contactUs) {
		ContactUs save = contactRepo.save(contactUs);
		
		return save;
	}


	@Override
	public List<ContactUs> getAllContactUs() {
		List<ContactUs> contactUs = contactRepo.findAll();
		
		return contactUs;
	}

}
