package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devglan.model.Booking;
import com.devglan.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@GetMapping("/{email:.+}")
	public ResponseEntity<List<Booking>> findUserBookings(@PathVariable String email) {
		System.out.println("email : "+email);

		List<Booking> bookings = bookingService.findUserBookings(email);
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}

}
