package com.jun.encapsulations;


/**
 * @author jeff yang
 * һ���򵥵ķ�װ���ӣ��ڲ� �õ�private, �ⲿ�õ�public��
 *
 */
public class Monitor {
	
	//��������public
	public static final String name="��ʾ��";
	
	//�������Զ���private.����(field)����� �����������á��������һĶ���ֵ�
	private String screen;
	private int size;
	private String color;
	
	private void lightScreen() {
		System.out.println("��ʾ�� ����");
	}
	
	public void start() {
		lightScreen();
		System.out.println("��ʾ�������� ");
	}

	//�����Ҫ�ı����ԣ����߻�ȡ���ԣ�����Ҫset,get������Ŀ����Ϊ�����ݰ�ȫ.
	public int getSize() {
		return size;
	}
	
	public void setSize(int size){
		switch (size) {
		case 14:
		case 19:
		case 21:
			this.size=size;
			break;
		default:
			System.out.println("�ߴ����");
		}
		
		
	}
}
