package com.sangupta.har;

import java.io.File;
import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import com.sangupta.har.model.Har;

public class HarTest {

	public static void main(String[] args) throws JsonSyntaxException, IOException {
		File file = new File("D:/workspace/Automation/Har文件解析/har/har/login_request_0.har");
		Har har = HarUtils.read(file);
		System.out.println("created by: " + har.log.creator.name);
	}
	
}
