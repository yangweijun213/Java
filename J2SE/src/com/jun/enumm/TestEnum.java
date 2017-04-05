package com.jun.enumm;


public class TestEnum {
	
	
	//枚举也是类和对象
	enum Week {
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURSDAY
	}
	
	static String testEnum (Week w){
		
		switch (w) {
		case SUNDAY:
			return "ri";
		case MONDAY:
			return "yi";
		case TUESDAY:
			return "er";
		case WEDNESDAY:
			return "san";
		case THURSDAY:
			return "si";
		case FRIDAY:
			return "wu";
		case SATURSDAY:
			return "liu";
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		Week ww = Week.FRIDAY;

		Week ww2 =Week.values()[2]; //返回在枚举中第三个常量
		
		String temp = testEnum(Week.SUNDAY);
		System.out.println(temp);
		
		System.out.println(Week.TUESDAY.ordinal());//返回在枚举中的索引
		System.out.println(Week.TUESDAY.toString());//返回在枚举中常量
		System.out.println(Week.TUESDAY.name());//返回在枚举中常量
		System.out.println(Week.TUESDAY);//返回在枚举中的常量
	}
}
