package com.bjsxt.others.en;

import java.util.StringTokenizer;

/**
 * Enumeration 子类
 * StringTokenizer:String split() 字符串分割
 * 不支持正则表达式
 * 
 * StringTokenizer(String str, String delim) 

 * @author Administrator
 *
 */
public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String emailStr="bjsxt@163.com;bjsxt@qq.com;bjsxt@sohu.com";
		StringTokenizer token =new StringTokenizer(emailStr,";");
		//遍历获取
		while(token.hasMoreElements()){
			System.out.println(token.nextElement());
		}
	}

}
