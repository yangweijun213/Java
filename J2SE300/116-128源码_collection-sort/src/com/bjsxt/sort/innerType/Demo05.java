package com.bjsxt.sort.innerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��Collections�������ıȽ�
 * 1�� public static <T> void sort(List<T> list, Comparator<? super T> c)  
 * 2��public static <T extends Comparable<? super T>> void sort(List<T> list)  
 * void sort(List<T> list)
 * @author Administrator
 *
 */
public class Demo05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list =new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		Collections.sort(list,new StringComp());
		System.out.println(list);
		
		
		list =new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		Collections.sort(list);
		System.out.println(list);
		
		
	}

}
