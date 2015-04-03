package com.cloud.hotel.dao;

import java.sql.SQLException;
import java.util.List;

import com.cloud.hotel.beans.BookingBean;
import com.cloud.hotel.beans.BookingRecordBean;
import com.cloud.hotel.common.ServiceLocatorException;

public interface BookingDAO {
	void insert(BookingBean booking) throws DataAccessException;
	void delete(int id) throws DataAccessException;
	BookingBean findBookingById(int id) throws DataAccessException;
	List <BookingBean> findAllBookings() throws DataAccessException;
	List <BookingBean> findBookingsByHotelId(int hotelid) throws DataAccessException;
	BookingBean findBookingByURL(String url) throws DataAccessException;
	Integer insertBookingAndRecords(BookingBean booking, List<BookingRecordBean> records) throws SQLException, ServiceLocatorException;
}
