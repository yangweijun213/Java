package com.jun.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	/**
	 * Load properties from property file
	 * 
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
