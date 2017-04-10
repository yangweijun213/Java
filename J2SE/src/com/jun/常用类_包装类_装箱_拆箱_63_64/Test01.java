package com.jun.常用类_包装类_装箱_拆箱_63_64;

/**
 * 测试包装类的基本用法
 * @author dell
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Integer  i = new Integer(1000);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toHexString(i));
		Integer i2 = Integer.parseInt("234"); //基本类型转整数包装类
		Integer i3 = new Integer("333");
		System.out.println(i2.intValue());
		String str = 234+"";
		
		
	}
}

