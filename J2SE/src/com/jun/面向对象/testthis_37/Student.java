package com.jun.面向对象.testthis_37;

public class Student {
	//静态的数据
	 String name;
	 int id;    //学号
	 
	 public Student (String name, int id){ 
		 this(); //调用其它Student()的构造器
		 this.name=name; //this 指代当前正要初始化的对象
		 this.id=id;
	 }
	 
	 public Student(){
		 
	 }
	 
	//动态的行为
	 public void study(){
		 this.name="xxx"; //当前方法的对象
		 System.out.println(name+"在學習");
	 }
	 
	 public void sayHello(String sname){
		 System.out.println(name+"向"+sname+"說：你好！");
	 }
}




