package com.bjsxt.thread.info;
/**
 *
  Thread.currentThread()	 :��ǰ�߳�
  setName():��������
  getName():��ȡ����
  isAlive():�ж�״̬

 * @author Administrator
 *
 */
public class InfoDemo01 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThread it =new MyThread();
		Thread proxy =new Thread(it,"����");
		proxy.setName("test");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName()); //main
		
		proxy.start();
		System.out.println("�������״̬:"+proxy.isAlive());
		Thread.sleep(200);
		it.stop();
		Thread.sleep(100);
		System.out.println("ֹͣ���״̬:"+proxy.isAlive());
	}

}
