package com.jun.thread;

public class TestCreateThread {

	public static void main(String[] args) {

		// 使用继承thread,调用线程
		// new createThread().start();
		new myThread("线程1").start();
		new myThread("线程2").start();
		
		//通过 实现runnable,来 调用 线程 
		new Thread(new myThread2("线程 2")).start();
	}

}

class myThread extends Thread {

	String threadName;

	@Override
	public void run() {
		// System.out.println("这是我的线程");

		// 获取线程名字
		for (int i = 1; i < 100; i++) {
			System.out.println(this.getName() + ":" + i);
		}
	}

	// 如果修改线程名字 ，需要定义一个构造方法，传名字
	public myThread(String name) {
		// 调用父类的构造方法
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
		// 获取线程名字
		for (int i = 1; i < 500; i++) {
			System.out.println(tname + ":" + i);
		}
	}
}
