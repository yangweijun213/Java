package com.jun.interfaceClass;

public interface A {
	void aa();
}

interface B{
	void b();
}

//�ӿ�C�̳��˽ӿ� A,B
interface C extends A,B{
	void c();
}

//ʵ����C�ӿں�Ҳ�̳��� �ӿ�A,�ӿ�B
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