package com.jun.interfaceClass;

public interface A {
	void aa();
}

interface B{
	void b();
}

//接口C继承了接口 A,B
interface C extends A,B{
	void c();
}

//实现了C接口后，也继承了 接口A,接口B
class ff implements C {

	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}
	
}