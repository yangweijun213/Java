package com.bjsxt.gen03;
/**
 * ���ͽӿ�:��̳�ͬ��
 * ��д�����游�����
 *
 * @param <T>
 */
public interface Comparable<T> {
	void compare(T t);
}
//��������ָ����������
class Comp implements Comparable<Integer>{

	@Override
	public void compare(Integer t) {
		// TODO Auto-generated method stub
		
	}
	
}
//����
class Comp1 implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}
	 
}
//������������෺��
class Comp2<T> implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}
	 
}
//���෺��>=���෺��
class Comp3<T> implements Comparable<T>{

	@Override
	public void compare(T t) {
		// TODO Auto-generated method stub
		
	}
	 
}
//���෺�ͣ�������� ����