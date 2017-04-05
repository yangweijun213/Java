package com.jun.thread;

public class TestCreateThread {

	public static void main(String[] args) {

		// ʹ�ü̳�thread,�����߳�
		// new createThread().start();
		new myThread("�߳�1").start();
		new myThread("�߳�2").start();
		
		//ͨ�� ʵ��runnable,�� ���� �߳� 
		new Thread(new myThread2("�߳� 2")).start();
	}

}

class myThread extends Thread {

	String threadName;

	@Override
	public void run() {
		// System.out.println("�����ҵ��߳�");

		// ��ȡ�߳�����
		for (int i = 1; i < 100; i++) {
			System.out.println(this.getName() + ":" + i);
		}
	}

	// ����޸��߳����� ����Ҫ����һ�����췽����������
	public myThread(String name) {
		// ���ø���Ĺ��췽��
		super(name);
	}

}

class myThread2 implements Runnable {

	private String tname;

	public myThread2(String tname) {
		super();
		this.tname = tname;
	}

	@Override
	public void run() {
		// ��ȡ�߳�����
		for (int i = 1; i < 500; i++) {
			System.out.println(tname + ":" + i);
		}
	}
}
