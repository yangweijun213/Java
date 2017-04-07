package com.jun.异常_71_72_73_74_75_76;

/**
 * 
 * @author Administrator
 *
 */
public class MyException extends Exception {
	
	public MyException(){
		
	}
	
	public MyException(String message){
		super(message); //调父类引用
	}
	
}

class TestMyException{
	void test()throws MyException{
		///
	}
	
	public static void main(String[] args) {
		try {
			new TestMyException().test();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
