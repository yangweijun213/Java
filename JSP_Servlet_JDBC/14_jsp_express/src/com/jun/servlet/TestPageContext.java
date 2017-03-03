package com.jun.servlet;

import javax.servlet.jsp.PageContext;

public class TestPageContext {

	public void test (PageContext pc) {
		System.out.println(pc.getRequest().getParameter("abc"));
	}
}
