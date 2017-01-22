package com.jun.recursion;

import com.jun.container.test;

/**
 * @author jeff yang ʹ�õݹ�͵�����ѭ����ʵ�� �ݹ��㷨
 *
 */
public class TestRecursion {

	 long test(long n) {
		 //�ݹ�ͷ
		 if (n==1){
			 return 1;
		 }else {
			 //�ݹ���
			 return n*test(n-1);
		 }
		 
	}

	public static void main(String[] args) {
		long d1=System.currentTimeMillis();
		System.out.println(new TestRecursion().test(3));
		long d2=System.currentTimeMillis();
		System.out.println(d2-d1);
		
		
		//����ʵ�ֵݹ�
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
