package com.jun.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestIterator {
	
	static void testList() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//1.list 
		for (int i=0;i<list.size();i++){
			String str = list.get(i);
			System.out.println(str);
		}
		
		//2.list 增强for 循环
		for (String str:list) {
			System.out.println(str);
		}
		
		//3.iterator  遍历时候需要删除，统一使用这个方式
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()){
			//返回下一个，游标移动一位
			String str = iter.next();
			System.out.println(str);
			iter.remove();
		}
	}
	
	static void testMap() {
		//1.
		Map m = new HashMap();
		m.put(1, "aaa");
		m.put(2, "bbb");
		m.put(3, "ccc");
		
		Set<Integer> s = m.keySet();
		for (Iterator<Integer> iter = s.iterator();iter.hasNext();){
			Integer name = iter.next();
			System.out.println(name+"===="+m.get(name));
		}
		
		Collection<String> c =m.values();
		for (String str:c){
			System.out.println(str);
		}
		
		
	}
	public static void main(String[] args) {
		
		//testList();
		testMap();
		
	}

}
