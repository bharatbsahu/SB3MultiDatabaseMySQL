/**
 * 
 */
package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.booking.dao.BookingDao;
import com.devglan.model.Booking;
import com.devglan.model.UserDetails;
import com.devglan.service.BookingService;
import com.devglan.user.dao.UserDao;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;

	public List<Booking> findUserBookings(String emailId) {
		System.out.println("email1 : "+emailId);
		UserDetails userdetails = userDao.findByEmail(emailId);
		System.out.println(userdetails.toString());
		//userdetails.getId()
		//long v =0;
		List<Booking> bookings = bookingDao.findByCreatedBy(userdetails.getId());
		System.out.println(bookings.toString());
		return bookings;
	}
}
