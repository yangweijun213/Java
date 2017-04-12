package com.bjsxt.test;

/**
 * 测试类加载器的层次结构、双亲委托机制
 * @author 尚学堂高淇  www.sxt.cn
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());   //JAVA_HOME/jre/lib/rt.jar
		System.out.println(System.getProperty("java.class.path")); //独立的，不会影响其它的类
		
		System.out.println("################");
		String a = "gaogao";  //java.lang.string 被引导类加载 了 
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a);
	}
}
