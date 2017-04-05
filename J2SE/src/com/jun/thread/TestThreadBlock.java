package com.jun.thread;

//下面例子说线程的阻塞：sleep, join, yield
public class TestThreadBlock {

	public static void main(String[] args) {
		
		StateThread st = new StateThread();
		st.start();
		StateThread st2 = new StateThread();
		st2.start();
		
//		System.out.println("爸爸和儿子买烟故事");
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
			
			//交出控制权(让CPU重新选择)
			Thread.yield();
		}
	}
	
}

class FatherThread extends Thread {

	@Override
	public void run() {
		System.out.println("爸爸想要抽烟,发现抽烟完了");
		System.out.println("爸爸让儿子去买包红塔山");

		// 分配新的thread对象 SonThread
		Thread son = new Thread(new SonThread());
		son.start();
		System.out.println("爸爸等儿子买烟回来");

		try {
			// 等儿子把烟买回来再抽。 等儿子执行完以后. 进入阻塞,等待
			son.join();
		} catch (InterruptedException e) {  //中断异常
			// TODO Auto-generated catch block
			e.printStackTrace();

			// 儿子没有在规定时间内把烟买回来，发生了异常，爸爸出去找儿子
			System.out.println("爸爸出去找儿子跑哪儿去了");
			System.exit(1); // 结束JVM, 如果是0则表示正常结束；如果是非0则表示非正常结束

		}

		// 儿子顺利买烟回来
		System.out.println("爸爸很高兴结果开始抽烟，并把零钱给儿子");

	}

}

class SonThread implements Runnable {
	@Override
	public void run() {
		System.out.println("儿子出去买烟");
		System.out.println("儿子买烟需要10分钟");

		try {
			for (int i = 1; i < 10; i++) {
				System.out.println("第" + i + "分钟");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("儿子买烟回来了");
	}

}
