package com.bjsxt.others.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 ����������չ
 1��MapIterator �Ժ���ʹ��map.keySet.iterator����
  IterableMap  HashedMap
 2��UniqueFilterIterator ȥ�ص����� 
 3��FilterIterator �Զ������ +Predicate
 4��LoopingIterator ѭ��������
 5��ArrayListIterator ���������
 * @author Administrator
 *
 */
public class Demo06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//mapIt();
		//uniqueIt();
		//filterIt();
		//loopIt();
		arrayIt();
	}
	/**
	 * ���������
	 */
	public static void arrayIt(){
		System.out.println("===== ���������  ====");
		int[] arr ={1,2,3,4,5};
		//���������
		//Iterator<Integer> it =new ArrayListIterator<Integer>(arr);
		//ָ����ʼ�����ͽ�������
		Iterator<Integer> it =new ArrayListIterator<Integer>(arr,1,3);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * ѭ��������
	 */
	public static void loopIt(){
		System.out.println("===== ѭ��������  ====");
		List<String> list =new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		
		Iterator<String> it =new LoopingIterator(list);
		for(int i=0;i<15;i++){
			System.out.println(it.next());
		}
	}
	/**
	 * �Զ�������� 
	 */
	public static void filterIt(){
		System.out.println("=====�Զ��������  ====");
		List<String> list =new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		//�Զ��������ж�
		Predicate<String> pre =new Predicate<String>(){
			public boolean evaluate(String value) {
				//�����ж�
				return new StringBuilder(value).reverse().toString().equals(value);
			}};
		
		
		//ȥ���ظ��Ĺ�����
		Iterator<String> it =new FilterIterator(list.iterator(),pre);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * ȥ�ص����� 
	 */
	public static void uniqueIt(){
		System.out.println("=====ȥ�ص����� ====");
		List<String> list =new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		//ȥ���ظ��Ĺ�����
		Iterator<String> it =new UniqueFilterIterator(list.iterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * map������
	 */
	public static void mapIt(){
		System.out.println("=====map������====");
		IterableMap<String,String> map =new HashedMap<String,String>();
		map.put("a","bjsxt");
		map.put("b", "sxt");
		map.put("c", "good");
		//ʹ�� MapIterator
		MapIterator<String,String> it =map.mapIterator();
		while(it.hasNext()){
			//һ��Ҫit.next() 
			/*
			it.next();
			String key =it.getKey();
			*/
			String key =it.next();
			String value =it.getValue();
			System.out.println(key+"-->"+value);
		}
		
		
	}

}
