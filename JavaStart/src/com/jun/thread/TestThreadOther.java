package com.jun.thread;

public class TestThreadOther {
	public static void main(String[] args) {
		Runnable r = new MyThread5();
		Thread t = new Thread (r,"Name test");
		t.start();
		
		//����̵߳�����
		System.out.println("�߳�������:"+t.getName());
		//���߳�һ������
		t.setName("Name test2");
		//����̵߳�����
		System.out.println("���ĺ�,�߳�������:"+t.getName());
		
		//�������ȼ���ֵ
		t.setPriority(10);
		//����߳����ȼ���ֵ
		System.out.println("�̵߳����ȼ�����ֵ��:"+t.getPriority());

		try {
			//��ǰ�߳�2����ʾ��ʽ������,��һ������
			Thread.currentThread().sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ж��߳��Ƿ���ֹ��
		System.out.println(t.isAlive());
	}

}

class MyThread5 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

	}
}
