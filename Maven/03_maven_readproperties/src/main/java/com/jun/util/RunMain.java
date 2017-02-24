package com.jun.util;

import java.util.Properties;

public class RunMain {

	public static void main(String[] args) throws Exception {
		String propertyFile = args[0];
		String userName = null;
		String password = null;

		Properties properties = ReadPropertiesFile.loadProperties(propertyFile);
		userName = properties.getProperty("userName");
		password = properties.getProperty("password");
		System.out.println("userName: "+userName);
		System.out.println("password: "+password);
	}
}
