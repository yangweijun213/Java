package com.jun.控制语句_17_18_19_20_21_22_23;

/*
 * switch语句_基本用法_case穿透现象
 */
public class TestSwitch {

	public static void main(String[] args) {

		int a = 3;

		switch (a) {
		case 1:
			System.out.println("a=1");
			break; // 执行到这里就跳出了,如果没有break,就会继续执行下去,直到下个语句遇到break

		case 2:
			System.out.println("a=2");
			break;

		case 3:
			System.out.println("a=3");
			break;
		default:
			System.out.println("no result");
			break;
		}

		int b = 1;

		switch (b) {
		case 1:
			System.out.println("b=1");

		case 2:
			System.out.println("b=2");

		case 3:
			System.out.println("b=3");
			break; // 执行到这里就跳出了,如果没有break,就会继续执行下去,直到下个语句遇到break
			
		case 4:
			System.out.println("b=4");
		}
	}
}
