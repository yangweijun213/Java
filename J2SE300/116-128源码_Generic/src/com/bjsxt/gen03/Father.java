package com.bjsxt.gen03;
/**
 * ����Ϊ������
 * 1������
 * 2������
 * 
 * Ҫôͬʱ������Ҫô������ڵ��ڸ��������,
 * ����������������෺��
 * 1����������
 *  �����У��游�����
 *  �����У����������
 * 2��������д:
 *  �游�����
 * 
 * 
 * @author Administrator
 *
 * @param <T>
 */
public abstract class Father<T,T1> {
	T name;
	public abstract void test(T t);

}
/**
 * ��������ʱָ����������
 * ��������Ϊ��������
 * ����ͬ��
 */
class Child1 extends Father<String,Integer>{
	String t2;
	@Override
	public void test(String t) {
	}	
}
/**
 * ����Ϊ������ ,������ʹ��ʱȷ��
 * @author Administrator
 *
 */
class Child2<T1,T,T3> extends Father<T,T1>{
	T1 t2;

	@Override
	public void test(T t) {
		
	}
	
	
}
/**
 * ����Ϊ�����࣬���಻ָ������ ,���͵Ĳ�����ʹ��Object�滻
 */
class Child3<T1,T2> extends Father{
	T1 name2;
	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub		
		
	}
	
}
/**
 * �����븸��ͬʱ����
 */
class Child4 extends Father{
	String name;	
	@Override
	public void test(Object t) {
		
	}
	
}
/**
 *����:�������������ʹ�÷���
class Child5 extends Father<T,T1>{
	String name;	
	@Override
	public void test(T t) {
		
	}
*/
	
