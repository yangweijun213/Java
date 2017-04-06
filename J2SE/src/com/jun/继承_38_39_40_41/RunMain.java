package com.jun.继承_38_39_40_41;


public class RunMain {
	
	public static void main(String[] args) {
		Animal a = new Animal();
		
		//调用继承属性
		Puluo p = new Puluo();
		p.chinai();
		
		//调用重写方法
		crawler c = new crawler();
		c.move(); //调用重写方法
	}
}
