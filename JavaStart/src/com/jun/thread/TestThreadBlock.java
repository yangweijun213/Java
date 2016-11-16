package com.jun.thread;

//��������˵�̵߳�������sleep, join, yield
public class TestThreadBlock {

	public static void main(String[] args) {
		
		StateThread st = new StateThread();
		st.start();
		StateThread st2 = new StateThread();
		st2.start();
		
//		System.out.println("�ְֺͶ������̹���");
//		FatherThread ft = new FatherThread();
//		ft.start();
	}
}

class StateThread extends Thread {

	@Override
	public void run() {
		for (int i=0; i<100;i++) {
			System.out.println(this.getName()+":"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//��������Ȩ(��CPU����ѡ��)
			Thread.yield();
		}
	}
	
}

class FatherThread extends Thread {

	@Override
	public void run() {
		System.out.println("�ְ���Ҫ����,���ֳ�������");
		System.out.println("�ְ��ö���ȥ�������ɽ");

		// �����µ�thread���� SonThread
		Thread son = new Thread(new SonThread());
		son.start();
		System.out.println("�ְֵȶ������̻���");

		try {
			// �ȶ��Ӱ���������ٳ顣 �ȶ���ִ�����Ժ�. ��������,�ȴ�
			son.join();
		} catch (InterruptedException e) {  //�ж��쳣
			// TODO Auto-generated catch block
			e.printStackTrace();

			// ����û���ڹ涨ʱ���ڰ�����������������쳣���ְֳ�ȥ�Ҷ���
			System.out.println("�ְֳ�ȥ�Ҷ������Ķ�ȥ��");
			System.exit(1); // ����JVM, �����0���ʾ��������������Ƿ�0���ʾ����������

		}

		// ����˳�����̻���
		System.out.println("�ְֺܸ��˽����ʼ���̣�������Ǯ������");

	}

}

class SonThread implements Runnable {
	@Override
	public void run() {
		System.out.println("���ӳ�ȥ����");
		System.out.println("����������Ҫ10����");

		try {
			for (int i = 1; i < 10; i++) {
				System.out.println("��" + i + "����");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("�������̻�����");
	}

}
