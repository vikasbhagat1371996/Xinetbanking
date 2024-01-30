package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
	
	Properties pro;
	
	public readconfig() {
	
	
	File src=new File("./configuration/config.properties") ;
	try {
	FileInputStream fis=new FileInputStream(src);
	pro=new Properties();
	pro.load(fis);
}catch(Exception e) {
    System.out.println("Exception is " + e.getMessage());
}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseurl");  //through pro.getproperty method we access the variable value on config .properties file.
		return url;
		
	}
	public String getusername() {
		String username=pro.getProperty("username");
		return username;
	}
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public String getchromepath() {
		String chromepath=pro.getProperty("Chromepath");
		return chromepath;     //return these value of chromepath
	}
	
	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefox");
		return firefoxpath;     //return these value of firefoxpath
	}
	
	public String getedgepath() {
		String Edgepath=pro.getProperty("Edge");
		return Edgepath;     //return these value ofEdgepathh
	}
	
		
	}
	

