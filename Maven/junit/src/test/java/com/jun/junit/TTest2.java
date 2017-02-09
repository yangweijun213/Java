package com.jun.junit;

import static org.junit.Assert.*; ////这是一个类，不是包。 有许多静态方法. 可以直接使用方法

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author jeff yang
 * Junit - 使用注解
 *
 */
public class TTest2 {
	
	@BeforeClass  //所有测试开始之前运行
	public static void BeforeClass(){
		System.out.println("所有测试开始之前运行");
	}
	
	@AfterClass  //所有测试结束之后运行
	public static void AfterClass(){
		System.out.println("所有测试结束之后运行");
		
	}
	
	@Before  //每一个测试方法之前运行
	public void Before(){
		System.out.println("每一个测试方法之前运行");
	}
	
	@After  //每一个测试方法之后运行
	public void After() {
		System.out.println("每一个测试方法之后运行");
	}
	
	@Test  //这个方法需要测试
	public void testAdd() {
		Double z  = new T().add(3.11111, 5.11111);
		assertEquals(8.22222,z,0.111);  //检查值是否相等.第一个是期待值 ，第二个是实际值,第三个是误差值
		System.out.println("testAdd");
	}
	
	@Test
	public void testAdd2() {
		int z  = new T().add2(3, 5);
		assertEquals(8, z);  //检查值是否相等。第一个是期待值 ，第二个是实际值，如果一样，就测试通过
		assertTrue(z>3); //检查条件是否为真。如果表达式返回true,则测试通过 
		assertTrue("too small", z>3); //检查条件是否为真，并打印消息。如果表达式返回true,则测试通过，并打印消息
		T t2 = new T();  
		T t1 = new T();
		assertEquals(t1,t1);//检查对象是否相等，类似 t1.equals(t1)
		assertSame(t1, t1);//检查对象是否相等。类似 t1==t1
//		assertNull(t2); //检查对象是否为空, 类似 == null, 初始化的对象为null
		
		System.out.println("testAdd2");
	}
	
	@Ignore  //被忽略的测试方法
	public void testAdd3() {
		Double z  = new T().add(3.11111, 5.11111);
		assertEquals(8.22222,z,0.111);  //检查值是否相等.第一个是期待值 ，第二个是实际值,第三个是误差值
		System.out.println("testAdd3");
	}
	
}

