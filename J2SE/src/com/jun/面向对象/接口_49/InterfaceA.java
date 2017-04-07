package com.jun.面向对象.接口_49;

/*
 * 实现接口
 */
public interface InterfaceA {
	void aaa();
}

interface InterfaceB{
	void bbb();
}

interface InterfaceC extends InterfaceA, InterfaceB{
	void cccc();
}

class TestClass implements InterfaceC{
	
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cccc() {
		// TODO Auto-generated method stub
		
	}
}

