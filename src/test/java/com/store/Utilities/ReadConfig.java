package com.store.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	String path = "E:\\Automation\\Amazon\\Configuration\\Config.properties";

	public ReadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public String getBaseURl() {
		String value = prop.getProperty("baseurl");
		if (value!=null) {
			return value;
		}
		else
			throw new RuntimeException("url not specified in Config");
	}
	
	public String getBrowser() {
		String value = prop.getProperty("browser");
		if (value!=null) {
			return value;
		}
		else
			throw new RuntimeException("browser not specified in Config");
	}
	
	public String getuid() {
		String value = prop.getProperty("uid");
		if (value!=null) {
			return value;
		}
		else
			throw new RuntimeException("uid not specified in Config");
	}
	
	public String getPwd() {
		String value = prop.getProperty("pwd");
		if (value!=null) {
			return value;
		}
		else
			throw new RuntimeException("pwd not specified in Config");
	}

}
