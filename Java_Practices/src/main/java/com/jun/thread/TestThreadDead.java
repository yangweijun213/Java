package com.jun.thread;

//stop(), destroy()�����Լ���ʱ������������ʵ������߳�����

public class TestThreadDead {
	public static void main(String[] args) {
		MyThread2 m2 = new MyThread2();
		m2.start();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ʹ��m2�������ã�����terminate()
		m2.terminate();
	}
}
	class MyThread2 extends Thread {
		
		 public boolean live = true;
		 
		//�Ҽ�->sources->Override/Implements Methods
		@Override
		public void run() {
			
			while (live){
				System.out.println("�߳�1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//��ֹ�̵߳ķ���
		public void terminate () {
			live = false;
			System.out.println("�߳�ִ�н�����");
		}
	}

