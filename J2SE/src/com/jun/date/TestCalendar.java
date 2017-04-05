package com.jun.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {

	public static void main(String[] args) {
		
		//calendar和long互转, 1月是0，2月是1,星期日是0
		Calendar c = new GregorianCalendar(1980,4,10);
		//加3天
		c.add(Calendar.DATE, 3);
		//减2年
		c.add(Calendar.YEAR, -2);
		//年数
		c.get(Calendar.YEAR);
		//一年中的第几天
		c.get(Calendar.DAY_OF_YEAR);
		
		//时间对象转换Calendar
		Date d = c.getTime();
		Calendar c2 = new GregorianCalendar();
		c2.setTime(d);
	}

}
