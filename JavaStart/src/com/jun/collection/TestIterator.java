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
		
		//2.list ��ǿfor ѭ��
		for (String str:list) {
			System.out.println(str);
		}
		
		//3.iterator  ����ʱ����Ҫɾ����ͳһʹ�������ʽ
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()){
			//������һ�����α��ƶ�һλ
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
