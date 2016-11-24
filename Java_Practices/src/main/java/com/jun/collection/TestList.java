package com.jun.collection;

import java.util.ArrayList;
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
	}

}

class Apple2 {
	int weight;
}
