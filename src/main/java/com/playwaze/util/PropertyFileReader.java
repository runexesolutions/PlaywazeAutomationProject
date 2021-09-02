package com.playwaze.util;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {
	
	String ConfigProp = System.getProperty("user.dir")+"/src/main/java/com/playwaze/properties/config.properties";
	 
	
	public String GetProperty(String key) throws Exception {
		FileReader reader=new FileReader(ConfigProp);
		Properties prop=new Properties();  
	    prop.load(reader);
	    return prop.getProperty(key);
	}

}
