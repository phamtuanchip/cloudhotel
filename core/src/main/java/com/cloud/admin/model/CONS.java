package com.cloud.admin.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CONS {
	public static final String TIME = "hh:mm dd-MM-yyy";
	public static final String DATE = "dd-MM-yyy";
	 
	public static String dateToString(Date d, String format){
		 SimpleDateFormat sf = new SimpleDateFormat(format);
		 return sf.format(d);
	 }
	
	public static String dateTimeToString(Date d, String format){
		 SimpleDateFormat sf = new SimpleDateFormat(format);
		 return sf.format(d);
	 }
	public static Date stringToDate(String d, String format){
		 SimpleDateFormat sf = new SimpleDateFormat(format);
		 try {
			return sf.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
	public static Date stringToDateTime(String d, String format){
		 SimpleDateFormat sf = new SimpleDateFormat(format);
		 try {
			return sf.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
}
