package com.turf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf.enities.ContactUs;

public interface ContactRepo extends JpaRepository<ContactUs, Integer> {

	
}
