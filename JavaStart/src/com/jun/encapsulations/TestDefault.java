package com.jun.encapsulations;

public class TestDefault {
	public static void main(String[] args) {
		TestDefault2 t2 = new TestDefault2();
		
		//��ͬһ�����ڣ�������
		t2.cc();
	}
}

class TestDefault2 {
	int a;

	//ʹ��default ���η���
	void cc() {
		System.out.println("ccc");
	}

	void dd() {
		// ֻ���ڱ����е���
		cc();
	}
}

class TestDefault2child extends TestDefault2 {
	void ee() {

		//��ͬһ�����ڵļ̳�Ҳ����
		super.cc();
	}
}