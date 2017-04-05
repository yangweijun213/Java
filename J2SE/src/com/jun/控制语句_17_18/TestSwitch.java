package com.jun.控制语句_17_18;

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
