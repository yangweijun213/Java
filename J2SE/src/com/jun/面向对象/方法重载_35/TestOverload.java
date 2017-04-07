package com.jun.面向对象.方法重载_35;

/*
 * 测试方法重载
 */
public class TestOverload {
	
}

class math {
	
	//构造方法重载
	public math(){
		
	}
	
	public math(int i){
		
	}
	
	public double add (int a, double b){ 
		return (a+b);
	}
	
	public double add (double a, int b){ //形参类型不同,重载
		return (a+b);
	}
	
	public double add (double a, int b, int c){ //形参个数不同,重载
		return (a+b+c);
	}
}
