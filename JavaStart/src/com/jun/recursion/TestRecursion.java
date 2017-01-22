package com.jun.recursion;

import com.jun.container.test;

/**
 * @author jeff yang 使用递归和迭代（循环）实现 递归算法
 *
 */
public class TestRecursion {

	 long test(long n) {
		 //递归头
		 if (n==1){
			 return 1;
		 }else {
			 //递归体
			 return n*test(n-1);
		 }
		 
	}

	public static void main(String[] args) {
		long d1=System.currentTimeMillis();
		System.out.println(new TestRecursion().test(3));
		long d2=System.currentTimeMillis();
		System.out.println(d2-d1);
		
		
		//迭代实现递归
		long i=3;
		long result=1;
		
		long d3=System.currentTimeMillis();
		while (i>1){
			result *=i*(i-1);
			i=i-2;
		}
		System.out.println(result);
		long d4=System.currentTimeMillis();
		System.out.println(d4-d3);
	}

}
