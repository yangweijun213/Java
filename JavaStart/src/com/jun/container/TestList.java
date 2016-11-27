package com.jun.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		
		//ʹ����Collection ��̬����listĥ���ˣ�һ��ʹ��List
		List c  = new ArrayList();
		//��������ֻ�ܷŶ���ʵ������c.add(new Integer(1))
		//c.add(1);
	
		c.add("a");
		c.add("b");
		c.add("c");
		//��1��λ��
		c.add(1,"0");
		
		//����
		c.set(1,"0");
		c.get(2);
		c.remove(3);
		
		List cc = c.subList(2, 3);
		System.out.println(cc);
		
		//List���ظ�
		Apple2 ap2 = new Apple2(10);
		List c2 = new ArrayList();
		c2.add(ap2);
		c2.add(ap2);
		c2.add(new Apple2(20));
		System.out.println(c2);
		
		//����List�����������Ե�
		Iterator iter = c2.iterator();
		while (iter.hasNext()){
			Apple2 a2 = (Apple2)iter.next();
			System.out.println("����c2���������weightֵ"+a2.weight);
		}
		
		//����List������toArray
		Object[] ss =c2.toArray();
		for (int i=0;i<ss.length;i++){
			System.out.println("��������c2�еĶ��� "+((Apple2)ss[i]).weight);
		}
	}
}

class Apple2 {
	int weight;

	public Apple2(int weight) {
		super();
		this.weight = weight;
	}
}
