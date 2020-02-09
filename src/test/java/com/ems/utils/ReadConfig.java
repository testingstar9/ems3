package com.ems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties ;
	
	public ReadConfig() {
		File file  = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String baseURL = properties.getProperty("baseURL");
		return baseURL;
	}
	
	public String getChromeDriverPath() {
		String chromepath = properties.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxDriverPath() {
		String firefoxpath = properties.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEDriverPath() {
		String iepath = properties.getProperty("iepath");
		return iepath;
	}
}
