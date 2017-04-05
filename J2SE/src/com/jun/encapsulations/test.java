package com.jun.encapsulations;


/**
 * @author jeff yang 一个高耦合的例子
 *
 */
public class test {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		int size=23;
		
		//下面代码就是高耦合
		switch (size){
		case 14:
		case 17:
		case 19:
			m.size=size;
			break;
		default:
			System.out.println("尺寸错误");
		}

	}
}
