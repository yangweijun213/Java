package com.jun.container;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		banana ba = new banana(10);
		banana ba2 = new banana(20);
		//�½�����
		Collection c1 = new HashSet();
		Collection c2 = new HashSet();
		Set c3 = new HashSet();
		HashSet c4 = new HashSet();
		//add(),������ӻ��¶���
		c1.add(ba);
		c1.add(ba2);
		c3.add(ba);
		c4.add(ba);
		System.out.println("����c1: "+c1);
		System.out.println("����c3: "+c3);
		System.out.println("����c4: "+c4);
		c1.add (new banana(30));
		System.out.println("����c1: "+c1);
		c2.add(c1);
		System.out.println("����c2: "+c2);
		//addAll(),��c2�����������c1�����е����ж���
		c2.addAll(c1);
		System.out.println("��c2�����������c1�����е����ж���: "+c2);
		//contains(), c1�������溬��banana����
		System.out.println("c1������banana����: "+c1.contains(ba));
		//containsAll(),c2�������溬��c1��������ж���
		System.out.println("c2�������溬��c1��������ж���: "+c2.containsAll(c1));
		//equal(), �Ƚ�����c1��c2�Ƿ����
		System.out.println("����c1��c2�Ƿ����: "+c2.equals(c1));
		//isEmpty(),����c1�Ƿ��ж���
		System.out.println("����c1�Ƿ��ж���: "+c1.isEmpty());
		//retainAll(),����c2��c1������Ԫ��
		c2.retainAll(c1);
		System.out.println("����c2��c1������Ԫ�غ�,c2: "+c2);
		//size(),��������c1�Ķ�����
		System.out.println("����c1�Ķ�����: "+c1.size());
		//toArray()������ȡ������c1ÿ�����������ֵ
		System.out.println("��������c1���ж��������: "+c1.toArray());
		Object s[]=c1.toArray();
		for (int i=0;i<s.length;i++){
			System.out.println ("c1������ÿ�����������weightֵ��"+((banana)s[i]).weight);
		}
		//iterator(),����ȡ������c1���ж��������ֵ
		Iterator iter = c1.iterator();
		while (iter.hasNext()){
			banana b =(banana)iter.next();
			System.out.println ("ÿ�����������weightֵ"+b.weight);
		}
		//�Ƴ�����c1����Ԫ��
		c1.clear();
		System.out.println("�Ƴ�����c1����Ԫ�غ�c1: "+c1);
		//�Ƴ�����c2����banana
		c2.remove(ba);
		System.out.println("�Ƴ�����c2����banana��c2: "+c2);
		//�Ƴ�����c2�е�c1���ж���
		c1.add(ba);
		c2.add(ba);
		System.out.println("c2: "+c2);
		System.out.println("c1: "+c1);
		c2.removeAll(c1);
		System.out.println("������c2�е�c1���ж����c2: "+c2);
		
	}
}

class banana {
	int weight;

	public banana(int weight) {
		super();
		this.weight = weight;
	}
}