package com.jun.junit;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class UsetTest {
	
	@Test
	public void testGetName() {
		
		User user1 = new User();
		User user2 = new User();
		assertSame(user1, user1);//检查对象是否相等。
	}

}
