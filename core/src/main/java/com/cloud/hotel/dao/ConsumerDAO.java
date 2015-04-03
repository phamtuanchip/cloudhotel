package com.cloud.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import com.cloud.hotel.beans.ConsumerBean;
import com.cloud.hotel.beans.UserBean;
import com.cloud.hotel.common.ServiceLocatorException;

public interface ConsumerDAO {
	ConsumerBean findConsumerById(int id) throws DataAccessException, ServiceLocatorException, SQLException;
	void insert(UserBean user,ConsumerBean customer) throws DataAccessException, ServiceLocatorException, SQLException;
	void delete(int id) throws DataAccessException, SQLException, ServiceLocatorException;
	List <ConsumerBean> findAllConsumers() throws DataAccessException, SQLException, ServiceLocatorException;
}
