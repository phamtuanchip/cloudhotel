package com.cloud.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import com.cloud.hotel.beans.HotelManagerBean;
import com.cloud.hotel.beans.UserBean;
import com.cloud.hotel.common.ServiceLocatorException;

public interface HotelManagerDAO {
	
	HotelManagerBean findManagerById(int id) throws DataAccessException, SQLException, ServiceLocatorException;
	void insert(UserBean user,HotelManagerBean manager) throws DataAccessException, ServiceLocatorException, SQLException;
	void delete(int id) throws DataAccessException, ServiceLocatorException, SQLException;
	List <HotelManagerBean> findAllManagers() throws DataAccessException, SQLException, ServiceLocatorException;
	HotelManagerBean findOwnerByUserName(String userName) throws SQLException, ServiceLocatorException;
}
