package com.jun.collection;

import java.util.ArrayList;
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
	}

}

class Apple2 {
	int weight;
}
