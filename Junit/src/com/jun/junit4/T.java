package com.jun.junit4;

public class T {
	public int add (int x, int y) {
		return x+y;
	}
	
	public int divide (int x, int y) {
		return x/y;
	}
	
	//ԭ��ʹ��main��ʽ���ԣ����������ʽ������
	public static void main(String[] args) {
		int z =new T().add(3, 5);
		System.out.println(z);
	}
}
