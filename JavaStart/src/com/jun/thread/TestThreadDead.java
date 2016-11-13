package com.jun.thread;

//stop(), destroy()方法以及过时，下面例子现实如何让线程死亡

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
		
		//使用m2对象引用，方法terminate()
		m2.terminate();
	}
}
	class MyThread2 extends Thread {
		
		 public boolean live = true;
		 
		//右键->sources->Override/Implements Methods
		@Override
		public void run() {
			
			while (live){
				System.out.println("线程1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//终止线程的方法
		public void terminate () {
			live = false;
			System.out.println("线程执行结束！");
		}
	}

