package com.jun.thread;

public class TestCreateThread {

	public static void main(String[] args) {

		// �����߳�
		//new createThread().start();
		
		new myThread("�߳�1").start();
		new myThread("�߳�2").start();
	}

}

class myThread extends Thread {
	
	String threadName;
	
	@Override
	public void run() {
		//System.out.println("�����ҵ��߳�");
		
		//��ȡ�߳�����
		for (int i=1;i<100;i++){
			System.out.println(this.getName()+":"+i);
		}
	}
	
	//����һ�����췽��
	public myThread (String name){
		//���ø���Ĺ��췽��
		super (name);
	}

}
