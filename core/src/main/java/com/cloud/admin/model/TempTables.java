package com.cloud.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cloud.hotel.model.services.Room;

public class TempTables {
	public static List<Room> BANGPHIEU = new ArrayList<Room>();
	
	static {
		BANGPHIEU.add(new Room("001", new Date(), "user01", 1, new Date(), "dichvu" , "P2001", "bs01"));
		BANGPHIEU.add(new Room("002", new Date(), "user01", 1, new Date(), "dichvu" , "P2001", "bs01"));
		BANGPHIEU.add(new Room("003", new Date(), "user01", 1, new Date(), "dichvu" , "P2001", "bs01"));
		BANGPHIEU.add(new Room("004", new Date(), "user01", 1, new Date(), "dichvu" , "P2001", "bs01"));
	}
}
