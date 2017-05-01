package com.bjsxt.thread.status;

public class YieldDemo01 extends Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		YieldDemo01 demo = new YieldDemo01();
		Thread t = new Thread(demo); //����
		t.start();//����
		//cpu���� ����
		
		
		for(int i=0;i<1000;i++){
			if(i%20==0){
				//��ͣ���߳� main
				Thread.yield();
			}
			System.out.println("main...."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("yield...."+i);
		}
	}

}
