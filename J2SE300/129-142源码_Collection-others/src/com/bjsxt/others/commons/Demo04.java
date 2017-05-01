package com.bjsxt.others.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * ���ϲ���
 * 1������
 * CollectionUtils.union();
 * 2������
 * CollectionUtils.intersection();
 * CollectionUtils.retainAll();
 * 3���
 *  CollectionUtils.subtract();
 * @author Administrator
 *
 */
public class Demo04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> set1 =new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		Set<Integer> set2 =new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		//����
		System.out.println("=========����============");
		Collection<Integer> col =CollectionUtils.union(set1,set2);
		for(Integer temp:col){
			System.out.println(temp);
		}
		//����
		System.out.println("=========����============");               
		//col =CollectionUtils.intersection(set1, set2);
		col =CollectionUtils.retainAll(set1, set2);
		for(Integer temp:col){
			System.out.println(temp);
		}
		//�
		System.out.println("=========�============");       
		col =CollectionUtils.subtract(set1, set2);
		for(Integer temp:col){
			System.out.println(temp);
		}		
	}

}
