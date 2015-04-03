package com.cloud.hotel.dao;

import java.util.List;

import com.cloud.hotel.beans.HotelUnavailabilityBean;

public interface HotelUnavailabilityDAO {
	void insert(HotelUnavailabilityBean hab) throws DataAccessException;
	void delete(int id) throws DataAccessException;
	List<HotelUnavailabilityBean> findByHotelId(int id) throws DataAccessException;
	List <HotelUnavailabilityBean> findAllHotelUnavailability() throws DataAccessException;
}
