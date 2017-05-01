package com.jun.callback;

public class PainFrame {
	//这段代码不需要更改
	public static void drawFrame(MyFrame f){
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息栈");	
		
		//画窗口
		f.paint(); //这个类似于钩，传的什么子类，就运行什么。
		
		System.out.println("启动缓存");
	}
	
	public static void main(String[] args) {
		drawFrame(new GameFrame01()); //调用了GameFrame01子类
	}

}

class GameFrame01 extends MyFrame{
	public void paint() {
		System.out.println("GameFrame01");
	}
}