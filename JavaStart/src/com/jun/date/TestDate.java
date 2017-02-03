package com.jun.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TestDate {
	
	public static void main(String[] args) {
		Date date =new Date();
		long dateNum =date.getTime();
		System.out.println(dateNum);
		
		//时间和字符串的互转 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date2 = df.parse("1980-2-3");
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
