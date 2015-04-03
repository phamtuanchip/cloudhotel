package com.cloud.hotel.dao;

import java.util.List;

import com.cloud.hotel.beans.BookingRecordBean;

public interface BookingRecordDAO {
	void insert(BookingRecordBean record) throws DataAccessException;
	void deleteByBooking(int id) throws DataAccessException;
	List <BookingRecordBean> findByBookingId(int id) throws DataAccessException;
	List <BookingRecordBean> findAllBookingRecord() throws DataAccessException;
}
