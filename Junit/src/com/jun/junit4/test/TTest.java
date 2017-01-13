package com.jun.junit4.test;

//����һ���࣬���ǰ��� ����ྲ̬����. ����ֱ��ʹ�÷���������Ҫ������ 
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jun.junit4.T;

public class TTest {
	
	@BeforeClass
	public static void BeforeClass(){
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void AfterClass(){
		System.out.println("AfterClass");
		
	}
	
	@Before
	public void Before(){
		System.out.println("Before");
	}
	
	@After
	public void After() {
		System.out.println("After");
	}
	
	
	@Test
	public void testAdd() {
		int z  = new T().add(5, 3);
		assertEquals(8, z);
		assertTrue(z>3);
		assertTrue("too small", z>3);
		
		//assertthat �����ԭ�����е�assert, ��Ӣ����Ȼ���Ը�ƥ��, �����hamcrest Matchers
		assertThat(z, is(8));
		
	}
	
	//@ignore �������淽��
	//@Ignore
	
	//��annotation ע�⣬˵��������ǲ��Է���
	//Junit4�Ժ�,����Ҫ�� try/catch, timeout=100 ����ִ�з�����Ҫ��100��ִ�����
	@Test (expected=java.lang.ArithmeticException.class, timeout=100)
	public void testDivide() {
		int z = new T().divide(6, 0);
		
		
	}
	
	
}

