package com.jun.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		
		//使用了Collection 多态，把list磨灭了，一般使用List
		List c  = new ArrayList();
		//容器里面只能放对象，实际上是c.add(new Integer(1))
		//c.add(1);
	
		c.add("a");
		c.add("b");
		c.add("c");
		//在1的位置
		c.add(1,"0");
		
		//区别
		c.set(1,"0");
		c.get(2);
		c.remove(3);
		
		List cc = c.subList(2, 3);
		System.out.println(cc);
		
		//List可重复
		Apple2 ap2 = new Apple2(10);
		List c2 = new ArrayList();
		c2.add(ap2);
		c2.add(ap2);
		c2.add(new Apple2(20));
		System.out.println(c2);
		
		//遍历List容器，有序性的
		Iterator iter = c2.iterator();
		while (iter.hasNext()){
			Apple2 a2 = (Apple2)iter.next();
			System.out.println("遍历c2容器对象的weight值"+a2.weight);
		}
		
		//遍历List容器，toArray
		Object[] ss =c2.toArray();
		for (int i=0;i<ss.length;i++){
			System.out.println("遍历容器c2中的对象： "+((Apple2)ss[i]).weight);
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
