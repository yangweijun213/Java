package com.jun.junit4.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jun.junit4.User;

public class UserTest {

	@Test
	public void testGetName() {
		assertThat(new User().getName(), is("Jeff"));
	}

}
