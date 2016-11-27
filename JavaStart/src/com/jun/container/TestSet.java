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
		//新建篮子
		Collection c1 = new HashSet();
		Collection c2 = new HashSet();
		Set c3 = new HashSet();
		HashSet c4 = new HashSet();
		//add(),添加篮子或新对象
		c1.add(ba);
		c1.add(ba2);
		c3.add(ba);
		c4.add(ba);
		System.out.println("篮子c1: "+c1);
		System.out.println("篮子c3: "+c3);
		System.out.println("篮子c4: "+c4);
		c1.add (new banana(30));
		System.out.println("篮子c1: "+c1);
		c2.add(c1);
		System.out.println("篮子c2: "+c2);
		//addAll(),在c2篮子里面添加c1篮子中的所有对象
		c2.addAll(c1);
		System.out.println("在c2篮子里面添加c1篮子中的所有对象: "+c2);
		//contains(), c1篮子里面含有banana对象
		System.out.println("c1篮子有banana对象: "+c1.contains(ba));
		//containsAll(),c2篮子里面含有c1里面的所有对象
		System.out.println("c2篮子里面含有c1里面的所有对象: "+c2.containsAll(c1));
		//equal(), 比较篮子c1和c2是否相等
		System.out.println("篮子c1和c2是否相等: "+c2.equals(c1));
		//isEmpty(),篮子c1是否有对象
		System.out.println("篮子c1是否有对象: "+c1.isEmpty());
		//retainAll(),篮子c2和c1交集的元素
		c2.retainAll(c1);
		System.out.println("篮子c2和c1交集的元素后,c2: "+c2);
		//size(),返回篮子c1的对象数
		System.out.println("篮子c1的对象数: "+c1.size());
		//toArray()，遍历取出篮子c1每个对象的属性值
		System.out.println("返回篮子c1所有对象的数组: "+c1.toArray());
		Object s[]=c1.toArray();
		for (int i=0;i<s.length;i++){
			System.out.println ("c1篮子中每个对象的属性weight值："+((banana)s[i]).weight);
		}
		//iterator(),遍历取出篮子c1所有对象的属性值
		Iterator iter = c1.iterator();
		while (iter.hasNext()){
			banana b =(banana)iter.next();
			System.out.println ("每个对象的属性weight值"+b.weight);
		}
		//移除篮子c1所有元素
		c1.clear();
		System.out.println("移除篮子c1所有元素后，c1: "+c1);
		//移除篮子c2对象banana
		c2.remove(ba);
		System.out.println("移除篮子c2对象banana后，c2: "+c2);
		//移除篮子c2中的c1所有对象
		c1.add(ba);
		c2.add(ba);
		System.out.println("c2: "+c2);
		System.out.println("c1: "+c1);
		c2.removeAll(c1);
		System.out.println("除篮子c2中的c1所有对象后，c2: "+c2);
		
	}
}

class banana {
	int weight;

	public banana(int weight) {
		super();
		this.weight = weight;
	}
}