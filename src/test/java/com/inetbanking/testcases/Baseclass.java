package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.readconfig;

public class Baseclass {
	
	readconfig readconfig1=new readconfig();//creating the object of readconfig class
                                            //it will invoke 
	public String baseurl=readconfig1.getApplicationURL();
	public String username=readconfig1.getusername();
	public String password=readconfig1.getpassword();
	
	public static WebDriver driver;
	
	public static Logger logger; 
	 @Parameters("browser" )
     @BeforeClass()
      public void setup(String br) {
	 if(br.equals("chrome")){
     System.setProperty("webdriver.chrome.driver",readconfig1.getchromepath());
	      
    	  ChromeOptions options = new ChromeOptions();
    	  options.addArguments("--remote-allow-origins=*");
    	// System.setProperty("webdriver.chrome.driver",System.getProperty("usr.dir")+"//Drivers//chromedriver.exe");
    	                                //system.getproperty declare the project homedirectory
    	 driver= new ChromeDriver(options);//which is for initialization of driver purpose used.
    	 
    	 logger=logger.getLogger("Xinetbankingv2");
    	 PropertyConfigurator.configure("log4j.properties");
     }
	 else if(br.equals("firefox")){
		 System.setProperty("webdriver.firefox.driver",readconfig1.getfirefoxpath());
		 driver= new EdgeDriver();
	      
	 }
	 else if(br.equals("Edge")) {
		 System.setProperty("webdriver.Edge.driver",readconfig1.getedgepath());
		 driver= new EdgeDriver();
		 
	 }
	 driver.get(baseurl);
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	 }
     
	@AfterClass()
	public void teardown() {
		//driver.quit();
	}
	 public void captureScreen(WebDriver driver,String tname) throws IOException {
         //passing two parameter driver and testname 
	TakesScreenshot ts=(  TakesScreenshot)driver;
  File source=ts.getScreenshotAs(OutputType.FILE);
  File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
  FileUtils.copyFile(source,target);   
  System.out.println("Screenshot taken");
  
}
	//These method is created because of to genrating a dynamic email
		public String randomString() {
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return generatedstring; 
		}
		public static String randomnum() {
			String generatedString2=RandomStringUtils.randomNumeric(4);
			return generatedString2;
		}

	 
}

	
	
	

