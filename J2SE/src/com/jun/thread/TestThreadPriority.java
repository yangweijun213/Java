package com.jun.thread;

public class TestThreadPriority {
	
	public static void main(String[] args) {
		
		Thread st1 = new Thread (new MyThread4(),"st1");
		Thread st2 = new Thread (new MyThread4(), "st2");
		st1.setPriority(1);
		st2.setPriority(10);
		st1.start();
		st2.start();
		
	}

}

class MyThread4 extends Thread {

	@Override
	public void run() {
		for (int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	
	}
	
}