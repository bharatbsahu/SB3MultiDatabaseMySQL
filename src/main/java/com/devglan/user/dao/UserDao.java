package com.devglan.user.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.devglan.model.UserDetails;

public interface UserDao extends CrudRepository<UserDetails, Long> {
	//@Query("select ud fr from UserDatails ud where ud.email=:email and ud.address=:address")
	//@Param("eamil"), @Param("address")String address
	UserDetails findByEmail(String email);
	
}
