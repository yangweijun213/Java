package com.jun.container;

import java.util.Collection;
import java.util.HashSet;

public class test {	
	public static void main(String[] args) {
		
		apple11 a = new apple11();
		Collection c1 = new HashSet();
		Collection c2 = new HashSet();
		c1.add(a);
		c1.add(new apple());
		c2.add(c1);
		System.out.println(c1);
		System.out.println(c2);
	}
}

class apple11 {
	int weight;
}