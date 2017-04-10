package com.jun.常用类_包装类_装箱_拆箱_63_64;

/**
 * 测试自动装箱和拆箱
 * @author dell
 *
 */
public class Test02 {
	public static void main(String[] args) {
//		Integer a = new Integer(1000);
		Integer a = 1000;  //jdk5.0之后 .  自动装箱，编译器帮我们改进代码：Integer a = new Integer(1000);
		
		int cc = new Integer(2000); //自动拆箱，编译器改进：new Integer(2000).intValue();
		Integer b = 2000;
		int c = b;  //自动拆箱，编译器改进：b.intValue();

		
		System.out.println(c); 
		
		Integer  d = 1234;
		Integer  d2 = 1234;
		
		System.out.println(d==d2);  //false, 2个不同的对象
		System.out.println(d.equals(d2)); //true, 它比较的是对象的属性(值 intvalue)
		
		System.out.println("###################"); 
		Integer d3 = -100;    //[-128,127]之间的数，仍然当做基本数据类型来处理。
		Integer d4 = -100;
		System.out.println(d3==d4); //true
		System.out.println(d3.equals(d4)); //true
		
		
	}
}
