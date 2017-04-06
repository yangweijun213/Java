package com.jun.静态_36;

public class Student {
	//静态的数据
	 String name;
	 int id;    //学号
	 int age;
	 String gender;
	 int weight;
	 
	 
	 static int ss; //静态变量
	 
	 Computer computer;
	 
	 public static void print() {
		 System.out.println();
	 }
	 
	//动态的行为
	 public void study(){
		 print(); //普通方法可以调用静态的方法,因为前面没有加类名,表示本类的方法.
		 System.out.println(name+"在學習");
	 }
	 
	 public void sayHello(String sname){
		 System.out.println(name+"向"+sname+"說：你好！");
	 }
	
}




