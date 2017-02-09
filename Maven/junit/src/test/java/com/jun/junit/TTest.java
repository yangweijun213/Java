package com.jun.junit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author jeff yang
 * Junit常用的assert用法 
 *
 */
public class TTest {
	
	@Test
	public void testAdd() {
		Double z  = new T().add(3.11111, 5.11111);
		assertEquals(8.22222,z,0.111);  //检查值是否相等.第一个是期待值 ，第二个是实际值,第三个是误差值
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
	}
	
}

