package com.jun.container;

import java.awt.SystemColor;
import java.util.Collection;
import java.util.HashSet;

//ע�⣬ȡ��warning
@SuppressWarnings("unchecked")
public class TestCollection {
	public static void main(String[] args) {
		//�½�����,����
		//Collection ����new, ������ ���� new��ѧϰ�ӽӿڿ�ʼ��Ȼ��������ʵ������new������ʹ��ʵ����HashSet
		Collection c = new HashSet();
		Collection c2 = new HashSet();
		apple a = new apple();
		c.add(a); //������ͬ����a
		c.add(a); //������ͬ����a
		c.add(a); //������ͬ����a
		System.out.println(c); 
		
		c.add(new apple()); //����һ���¶���
		c.add(new apple()); //����һ���¶���
//		c2.addAll(c);  //��������������Ԫ��
		c2.add(c); //��������Ҳ�Ƕ���c����������c2��
//		System.out.println(c);
		System.out.println(c2);
//		System.out.println (c2.contains(new apple())); //false
//		System.out.println(c.contains(a)); //true
//		System.out.println(c.isEmpty());
		
//		c.remove(a);
//		System.out.println(c);
		
//		c2.retainAll(c2);
//		System.out.println(c2);
	} 
	
}

	class apple {
		int weight;
	}
