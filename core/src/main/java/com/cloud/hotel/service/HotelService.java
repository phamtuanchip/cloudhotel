package com.cloud.hotel.service;

import java.util.List;

import javax.naming.AuthenticationException;

import com.cloud.model.User;

public interface HotelService {

	//admin 
	public User findByUsername(String username);
	public User save(User user);
	public User update(User user);
	public int delete(String username);
	public List<User> listUsers();	

	public User login(User u) throws AuthenticationException;
	
	public User register(User u);
	 
}
