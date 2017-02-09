package com.jun.maventest;


import static org.junit.Assert.*;
import org.junit.Test;

public class TestApp {

	@Test
	public void testAdd2() {
		int z  = new App().add2(3, 5);
		assertEquals(8, z);  //检查值是否相等。第一个是期待值 ，第二个是实际值，如果一样，就测试通过
	}
	
}
