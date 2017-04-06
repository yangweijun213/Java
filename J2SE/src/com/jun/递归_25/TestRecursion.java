package com.jun.递归_25;

import com.jun.container.test;

/**
 * 测试递归
 *
 */
public class TestRecursion {
	
	//测试递归 5*4*3*2*1
	 long test(long n) {
		 if (n==1){
			 return 1;
		 }else {
			 return n*test(n-1);
		 }
		 
	}

	public static void main(String[] args) {
		
		//计算递归的效率
		long d1=System.currentTimeMillis();
		System.out.println(new TestRecursion().test(10));
		long d2=System.currentTimeMillis();
		System.out.println("递归的效率： "+ (d2-d1));
		
		
		long i=10;
		long result=1;
		
		//计算循环的效率
		long d3=System.currentTimeMillis();
		while (i>1){
			result *=i*(i-1);
			i=i-2;
		}
		System.out.println(result);
		long d4=System.currentTimeMillis();
		System.out.println("循环的效率： "+(d4-d3));
	}

}
