package com.bjsxt.thread.info;
/**
 * ���ȼ�:���ʣ����Ǿ��Ե��Ⱥ�˳��
   MAX_PRIORITY  10
   NORM_PRIORITY 5 (Ĭ��)
   MIN_PRIORITY  1
   
   setPriority()
   getPriority()
 * @author Administrator
 *
 */
public class InfoDemo02 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThread it =new MyThread();
		Thread p1 =new Thread(it,"����1");
		MyThread it2 =new MyThread();
		Thread p2 =new Thread(it2,"����2");
		
		p1.setPriority(Thread.MIN_PRIORITY); //�������ȼ�
		p2.setPriority(Thread.MAX_PRIORITY);//�������ȼ�
		p1.start();
		p2.start();
		
		
		
		Thread.sleep(100);
		it.stop();
		it2.stop();
	}

}
