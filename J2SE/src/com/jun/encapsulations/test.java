package com.jun.encapsulations;


/**
 * @author jeff yang һ������ϵ�����
 *
 */
public class test {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		int size=23;
		
		//���������Ǹ����
		switch (size){
		case 14:
		case 17:
		case 19:
			m.size=size;
			break;
		default:
			System.out.println("�ߴ����");
		}

	}
}
