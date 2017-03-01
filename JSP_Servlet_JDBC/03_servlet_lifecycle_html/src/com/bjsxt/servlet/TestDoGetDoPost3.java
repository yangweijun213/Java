package com.bjsxt.servlet;

public class TestDoGetDoPost3 {

	public static void main(String[] args) {
		ChildServlet cs = new ChildServlet();
		cs.service();
	}
}

class MyHttpServlet {

	void service() {
		System.out.println("father service");
	}

	void doGet() {
		System.out.println("father doGet");
	}
}

class ChildServlet extends MyHttpServlet {

	void service() {
		System.out.println("son service");
		super.service();
	}

	void doGet() {
		System.out.println("son doGet");
	}
}
