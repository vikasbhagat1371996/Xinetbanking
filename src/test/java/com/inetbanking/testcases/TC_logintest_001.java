package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;

public class TC_logintest_001 extends Baseclass {
	
	
	@Test
	public void logintest() throws IOException {
		driver.get(baseurl);
		
		logger.info("url is open");
		loginpage lp=new loginpage(driver);
		
		lp.setusername(username);
		logger.info("username is entered");
		lp.setpassword(password);
		logger.info("password is entered");
		lp.clicksubmit();
		logger.info("clicked on submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else {
			captureScreen(driver,"TC_logintest_001");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
	

}
