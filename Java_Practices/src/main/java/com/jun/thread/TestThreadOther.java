package com.jun.thread;

public class TestThreadOther {
	public static void main(String[] args) {
		Runnable r = new MyThread5();
		Thread t = new Thread (r,"Name test");
		t.start();
		
		//获得线程的名字
		System.out.println("线程名字是:"+t.getName());
		//给线程一个名字
		t.setName("Name test2");
		//获得线程的名字
		System.out.println("更改后,线程名字是:"+t.getName());
		
		//设置优先级数值
		t.setPriority(10);
		//获得线程优先级数值
		System.out.println("线程的优先级的数值是:"+t.getPriority());

		try {
			//当前线程2个表示方式都可以,都一回事情
			Thread.currentThread().sleep(1000);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//判断线程是否终止了
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
