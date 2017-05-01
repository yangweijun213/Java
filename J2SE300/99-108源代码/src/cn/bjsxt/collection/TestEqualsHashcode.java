package cn.bjsxt.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestEqualsHashcode {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		Object obj;
		System.out.println(str1.equals(str2)); 
		
		//Set:无序不可重复(equals)！List：有序可重复。
		//Map：key不可重复
		Map m  = new HashMap();
		m.put("abc", new String("aaa"));
		m.put(new String("abc"), new String("bbb"));
		System.out.println(m.size());
		
		
		Set set = new HashSet();
		set.add(new Integer(234));
		set.add(new Integer(234));
		System.out.println(set.size()); 
		
		
	}
}

class Cat {
	int id;
	String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}

