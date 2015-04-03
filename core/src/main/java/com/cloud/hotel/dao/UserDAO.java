package com.cloud.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import com.cloud.hotel.beans.UserBean;
import com.cloud.hotel.common.ServiceLocatorException;

public interface UserDAO {
	
	UserBean findUserById(int id) throws DataAccessException, ServiceLocatorException, SQLException;
	void insert(UserBean user) throws DataAccessException, ServiceLocatorException, SQLException;
	void delete(int id) throws DataAccessException, SQLException, ServiceLocatorException;
	List <UserBean> findAllUsers() throws DataAccessException, Exception;
	UserBean findByEmail(String email) throws SQLException, ServiceLocatorException;

}
