package com.jun.junit4.test;

//这是一个类，不是包。 有许多静态方法. 可以直接使用方法，不需要类名了 
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
		
		//assertthat 替代了原先所有的assert, 和英语自然语言更匹配, 结合了hamcrest Matchers
		assertThat(z, is(8));
		
	}
	
	//@ignore 忽略下面方法
	//@Ignore
	
	//加annotation 注解，说明下面的是测试方法
	//Junit4以后,不需要加 try/catch, timeout=100 下面执行方法需要在100秒执行完成
	@Test (expected=java.lang.ArithmeticException.class, timeout=100)
	public void testDivide() {
		int z = new T().divide(6, 0);
		
		
	}
	
	
}

