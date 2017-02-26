package com.jun.util;

import java.util.Properties;
import java.io.*;

public class ReadPropertiesFile {

	/**
	 * Load properties from property file
	 * @param propertyFile
	 * @return
	 * @throws Exception
	 */
	public static Properties loadProperties(String propertyFile) throws Exception {
		Properties properties = null;
		try {
			properties = new Properties();
			InputStream inputStream = new FileInputStream(propertyFile);
			properties.load(inputStream);
		} catch (FileNotFoundException fnfe) {
			throw new Exception("File " + propertyFile + " do not find, please check !", fnfe);
		} catch (IOException ioe) {
			throw new Exception("Error during load properties from file " + propertyFile + ", please check !", ioe);
		}
		return properties;
	}
}
