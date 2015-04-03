package com.cloud.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import com.cloud.hotel.beans.HotelOwnerBean;
import com.cloud.hotel.beans.UserBean;
import com.cloud.hotel.common.ServiceLocatorException;

public interface HotelOwnerDAO {
	HotelOwnerBean findOwnerById(int id) throws DataAccessException, ServiceLocatorException, SQLException;
	void insert(UserBean user,HotelOwnerBean owner) throws DataAccessException, ServiceLocatorException, SQLException;
	void delete(int id) throws DataAccessException, ServiceLocatorException, SQLException;
	List <HotelOwnerBean> findAllOwners() throws DataAccessException, SQLException, ServiceLocatorException;
	HotelOwnerBean findOwnerByUserName(String userName) throws SQLException, ServiceLocatorException;

}
