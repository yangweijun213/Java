package com.jun.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;


/**
 * 描述 ：java与json互相转换
 * 参考： http://www.yuuzle.com/java-and-json-conversion-to-resolve-the-question-of-the-date.html
 * @author jeff yang
 * 
 */
public class JavaToJson {
	
	public static void main(String[] args) {
		
		//List-》JSON
		List<String> list = new ArrayList<String>();  
		list.add("apple");  
		list.add("orange");  
		JSONArray jarr = JSONArray.fromObject(list);  
		System.out.println("list->json:" + jarr.toString());
		
	}
}
