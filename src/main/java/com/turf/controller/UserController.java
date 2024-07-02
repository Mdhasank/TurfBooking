package com.turf.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turf.enities.Booking;
import com.turf.enities.ContactUs;
import com.turf.enities.Customer;
import com.turf.repository.CustomerRepository;
import com.turf.service.BookingService;
import com.turf.service.ContactService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ContactService contactService;

	@Autowired
	private BookingService bookingService;

	@GetMapping("/mybooking")
	public String mybooking(Model model, Principal principal) {

		String name = principal.getName();
		List<Booking> allBookings = bookingService.getAllBookings();

		model.addAttribute("allBookings", allBookings);
		Customer customer = customerRepository.findByEmail(name);
		// model.addAttribute("customers", customerService.getAllCustomers());

		model.addAttribute("customer", customer);
		return "user/mybooking";
	}

	@PostMapping("/saveContact")
	public String saveContact(@Valid @ModelAttribute("contactUs") ContactUs contactUs, BindingResult result,
			Model model, HttpSession session) {

		if (result.hasErrors()) {
			return "contact";
		}

		ContactUs saveContact = contactService.saveContact(contactUs);

		if (!ObjectUtils.isEmpty(saveContact)) {
			session.setAttribute("succMsg", "Query Saved Successfully");
		} else {
			session.setAttribute("succMsg", "Something Went Wrong!!!!!!");
		}

		return "redirect:/contact";
	}

}
