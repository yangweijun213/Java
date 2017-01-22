package com.jun.enumm;


public class TestEnum {
	
	
	//ö��Ҳ����Ͷ���
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

		Week ww2 =Week.values()[2]; //������ö���е���������
		
		String temp = testEnum(Week.SUNDAY);
		System.out.println(temp);
		
		System.out.println(Week.TUESDAY.ordinal());//������ö���е�����
		System.out.println(Week.TUESDAY.toString());//������ö���г���
		System.out.println(Week.TUESDAY.name());//������ö���г���
		System.out.println(Week.TUESDAY);//������ö���еĳ���
	}
}
