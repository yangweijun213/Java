package com.jun.inheritance;


/**
 * @author jeff yang
 * ���ʹ���˼̳У����Լ����ظ��ķ��������� , Animal�������� 
 *
 */
public class TestExtend2 {
	
	class Animal {
		int age;
		int weight;
		int speed;
		int height;
		void move() {
			System.out.println("���� �ƶ� ");
		}
	}
	
	class Puluo extends Animal {

		String puluo;	
		//��չ�µķ���
		void chinai() {
			System.out.println("���ڳ��� ");
		}
	}
	
	class crawler extends Animal {
		
		//��д�� ����  (���¶���)
		@Override
		void move() {
			System.out.println("�������� ");
		}
	}

}
