package com.jun.inheritance;


/**
 * @author jeff yang
 * ���û�м̳л��������ظ��ʺܸ� ������ ��
 *
 */
public class TestExtend {
	
	class Animal {
		int age;
		int weight;
		int speed;
		int height;
		void move() {
			System.out.println("���� �ƶ� ");
		}
	}
	
	class Puluo {
		int age;
		int weight;
		int speed;
		int height;
		String puluo;
		void move() {
			System.out.println("���� �ƶ� ");
		}
		
		void chinai() {
			System.out.println("���ڳ��� ");
		}
	}
	
	class crawler {
		int age;
		int weight;
		int speed;
		int height;
		void move() {
			System.out.println("�������� ");
		}
	}

}
