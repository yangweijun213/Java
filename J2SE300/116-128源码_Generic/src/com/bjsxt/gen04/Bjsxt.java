package com.bjsxt.gen04;

public class Bjsxt <T>{
 T stu ;
 
 
 public static void main(String[] args) {
	 //���͵�Ƕ�� 
	 Bjsxt<Student<String>> room =new  Bjsxt<Student<String>>();
	 //���⵽�ڲ��
	 room.stu = new Student<String>();
	 Student<String> stu = room.stu;
	 String score =stu.score;
	 System.out.println(score);
}
}
