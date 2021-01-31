package com.scrolltest.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	
	private static ConfigManager manager;
	private static final Properties prop = new Properties();
	
	private ConfigManager() throws Exception {
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		//System.out.println(inputStream);
		//System.out.println("Teepti in Config");
		prop.load(inputStream);
		//System.out.println("Teepti in Config2");
		
	}
	 public static ConfigManager getInstance() {
		 
		 if(manager == null) {
			 synchronized (ConfigManager.class) {
				 try {
					manager = new ConfigManager();
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			 }
		 }
		 //System.out.println("Teepti in Config3");
		  return manager;
		 
	 }
	 
	 public String getString(String key) {
		
		 return System.getProperty(key, prop.getProperty(key));
		 
	 }

}
