package com.jun.junit;

import static org.junit.Assert.*; ////这是一个类，不是包。 有许多静态方法. 可以直接使用方法
import static org.hamcrest.Matchers.*;
import org.hamcrest.core.Is;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

/**
 * @author jeff yang
 * junit4和hamcrest使用 
 *
 */
public class TTest3 {
	
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
	
		
	@Test
	public void testAdd2() {
		int z  = new T().add2(3, 5);
		//assertthat 替代了原先所有的assert, 和英语自然语言更匹配, 结合了hamcrest Matchers
		assertThat(z, is(8));
	}
	
	@Ignore  //被忽略的测试方法
	public void testAdd3() {
		Double z  = new T().add(3.11111, 5.11111);
		assertEquals(8.22222,z,0.111);  //检查值是否相等.第一个是期待值 ，第二个是实际值,第三个是误差值
		System.out.println("testAdd3");
	}
	
}

