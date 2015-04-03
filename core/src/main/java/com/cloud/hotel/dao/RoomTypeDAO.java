package com.cloud.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import com.cloud.hotel.beans.RoomTypeBean;
import com.cloud.hotel.common.ServiceLocatorException;

public interface RoomTypeDAO {
	void insert(RoomTypeBean rtype) throws DataAccessException, ServiceLocatorException, SQLException;
	void delete(String rtype) throws DataAccessException, SQLException, ServiceLocatorException;
	RoomTypeBean findByRoomType(String rtype) throws DataAccessException, ServiceLocatorException, SQLException;
	List<RoomTypeBean> findAllRoomTypes() throws DataAccessException, ServiceLocatorException, SQLException;

}
