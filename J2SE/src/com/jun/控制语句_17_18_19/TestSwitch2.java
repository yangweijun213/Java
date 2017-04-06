package com.jun.控制语句_17_18_19;

/*
 * jdk7.0新特性_增强switch语句 - switch表达式可以是字符串
 */
public class TestSwitch2 {

	public static void main(String[] args) {
		String a = "测试";
		switch (a) { // JDK7的新特性，表达式结果可以是字符串！！！
		case "测":
			System.out.println("测");
			break;
		case "测试":
			System.out.println("测试");
			break;
		default:
			System.out.println("试！");
			break;
		}
	}

}
