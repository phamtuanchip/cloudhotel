package com.cloud.hotel.service.impl;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cloud.hotel.service.HotelService;
import com.cloud.model.User;

public class HotelServiceMongoImpl implements HotelService{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Autowired
	public MongoOperations mongoTemplate ; 

 

	public MongoOperations getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoOperations mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User u) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User register(User u) {
		// TODO Auto-generated method stub
		return null;
	}



}
