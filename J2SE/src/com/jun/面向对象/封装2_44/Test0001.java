package com.jun.面向对象.封装2_44;

import com.jun.面向对象.封装_44.Test01;

public class Test0001 extends Test01 {
	
	public void ttt(){
		super.print();
		print();
	}
	
	public static void main(String[] args) {
		Test0001 t = new Test0001();
		t.print();
	}
	
}
