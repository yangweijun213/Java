package com.jun.thread;

public class TestCreateThread {

	public static void main(String[] args) {

		// 调用线程
		//new createThread().start();
		
		new myThread("线程1").start();
		new myThread("线程2").start();
	}

}

class myThread extends Thread {
	
	String threadName;
	
	@Override
	public void run() {
		//System.out.println("这是我的线程");
		
		//获取线程名字
		for (int i=1;i<100;i++){
			System.out.println(this.getName()+":"+i);
		}
	}
	
	//定义一个构造方法
	public myThread (String name){
		//调用父类的构造方法
		super (name);
	}

}
