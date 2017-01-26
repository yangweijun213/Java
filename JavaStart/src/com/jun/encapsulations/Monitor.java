package com.jun.encapsulations;


/**
 * @author jeff yang
 * 一个简单的封装例子（内部 用的private, 外部用的public）
 *
 */
public class Monitor {
	
	//常量可以public
	public static final String name="显示器";
	
	//所有属性都是private.属性(field)，你的 领域不能随便调用。例如你加一亩三分地
	private String screen;
	private int size;
	private String color;
	
	private void lightScreen() {
		System.out.println("显示器 亮了");
	}
	
	public void start() {
		lightScreen();
		System.out.println("显示器点亮了 ");
	}

	//如果需要改变属性，或者获取属性，就需要set,get方法，目的是为了数据安全.
	public int getSize() {
		return size;
	}
	
	public void setSize(int size){
		switch (size) {
		case 14:
		case 19:
		case 21:
			this.size=size;
			break;
		default:
			System.out.println("尺寸错误");
		}
		
		
	}
}
