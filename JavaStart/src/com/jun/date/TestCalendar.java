package com.jun.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {

	public static void main(String[] args) {
		
		//calendar��long��ת, 1����0��2����1,��������0
		Calendar c = new GregorianCalendar(1980,4,10);
		//��3��
		c.add(Calendar.DATE, 3);
		//��2��
		c.add(Calendar.YEAR, -2);
		//����
		c.get(Calendar.YEAR);
		//һ���еĵڼ���
		c.get(Calendar.DAY_OF_YEAR);
		
		//ʱ�����ת��Calendar
		Date d = c.getTime();
		Calendar c2 = new GregorianCalendar();
		c2.setTime(d);
	}

}
