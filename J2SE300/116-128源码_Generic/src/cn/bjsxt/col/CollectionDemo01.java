package cn.bjsxt.col;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
���Ԫ�� C
boolean add(E e)   
�鿴Ԫ�� R
size() ����������С
contains(Object o) �ж��Ƿ����Ԫ�� ������дequals�Ƚ�����
isEmpty()  �ж������Ƿ�Ϊ��
ɾ��Ԫ�� D
remove(Object o) ɾ��ָ����Ԫ�أ������Զ���������дequals
clear()  �������
��������:toArray()  toArray(T[] a) 

����:�鿴��������
foreach
iterator() ������
û��ͨ���±���ʵ�for





 * @author Administrator
 *
 */
public class CollectionDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��̬ :���� ��������������
		Collection<String> col =new ArrayList<String>();
		create(col);
		retrieve(col);
		delete(col);
		
		System.out.println(col.size());
		
		
		create(col);
		String[] arr =col.toArray(new String[0]);
		System.out.println(arr.length);
		System.out.println(arr[0]);
		iterCol(col);
		
	}
	/**
	 * ��������
	 */
	public static void iterCol(Collection<String> col){
		System.out.println("=========��ǿfor foreach �������±�======");
		for(String temp:col){
			System.out.println(temp);
		}
		System.out.println("=========������======");
		Iterator<String>  it =col.iterator();
		while(it.hasNext()){
			String temp =it.next();
			System.out.println(temp);
		}
	}
	
	
	/**
	 *ɾ��
	 * 1��remove(����)
	 * 2��clear() �������
	 * @param col
	 */
	public static void delete(Collection<String> col){
		boolean flag =col.remove("�ձ�");
		System.out.println(flag);
		col.clear();
	}
	/**
	 * �鿴
	 * 1����С
	 * 2���鿴
	 * 3���Ƿ�Ϊ��
	 * @param col
	 */
	public static void retrieve(Collection<String> col){
		System.out.println("�����Ĵ�С:"+col.size());
		System.out.println("�鿴"+col.contains("����"));
		System.out.println("�����Ƿ����Ԫ��"+col.isEmpty());
	}
	/**
	 * ���Ԫ��
	 * 1��������������
	 * @param col
	 */
	public static void create(Collection<String> col){
		col.add("����");
		col.add("�й�");
		
	}

}
