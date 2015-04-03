package com.cloud.hotel.dao.support.test;


import com.cloud.hotel.beans.UserBean;
import com.cloud.hotel.common.DBConnectionFactory;
import com.cloud.hotel.dao.support.UserDAOImpl;
public class UserDAOImplTest {
	public void insertUser() throws Exception{
		DBConnectionFactory services = new DBConnectionFactory();
		UserBean user = new UserBean();
		user.setAddress("Address");
		user.setEmail("email");
		user.setName("name");
		user.setPhoneNumber(1);
		
		UserDAOImpl udi = new UserDAOImpl(services);
		udi.insert(user);
		
	}
}
