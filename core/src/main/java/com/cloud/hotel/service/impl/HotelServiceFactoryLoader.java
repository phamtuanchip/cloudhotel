package com.cloud.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.hotel.service.HotelService;
import com.cloud.hotel.service.HotelServiceFactory;

public class HotelServiceFactoryLoader implements HotelServiceFactory {
	@Autowired
	private HotelService service;
	
	public void setService(HotelService service) {
		this.service = service;
	}

	@Override
	public HotelService getService() {
		return service;
	}

}
