package com.jun.container;

import java.awt.SystemColor;
import java.util.Collection;
import java.util.HashSet;

//注解，取消warning
@SuppressWarnings("unchecked")
public class TestCollection {
	public static void main(String[] args) {
		//新建容器,篮子
		//Collection 不能new, 抽象类 不能 new。学习从接口开始，然后找它的实现类来new。这里使用实现类HashSet
		Collection c = new HashSet();
		Collection c2 = new HashSet();
		apple a = new apple();
		c.add(a); //增加相同对象a
		c.add(a); //增加相同对象a
		c.add(a); //增加相同对象a
		System.out.println(c); 
		
		c.add(new apple()); //增加一个新对象
		c.add(new apple()); //增加一个新对象
//		c2.addAll(c);  //增加容器中所有元素
		c2.add(c); //容器本身也是对象，c容器放在了c2中
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
