package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Addcustomerpage;
import com.inetbanking.pageobjects.loginpage;

public class TC_Addcustomerpage_003 extends Baseclass{
	
	
	@Test(priority=1)
	public void addcustomer() throws InterruptedException, IOException {
		
		//For calling methos on Loginpage for that purpose Creating object of Login page
		  
		
		
			loginpage lp=new loginpage(driver);
			lp.setusername(username);
			lp.setpassword(password);
			lp.clicksubmit();  
			
			Thread.sleep(3000);
			
		//	lp.clickLogout();
			
			Addcustomerpage addcuts=new Addcustomerpage(driver);
			
		//	driver.switchTo().alert().dismiss();
			addcuts.clickAddNewCustomer();
			addcuts.custName("vikas");
			addcuts.custgender("male");
			addcuts.custdob("13", "07", "1996");
			addcuts.custaddress("malkhambi");
			addcuts.custcity("tapari");
			addcuts.custpinno("413112");
			addcuts.custmobilno("9975056532");
			addcuts.custstate("maharastra");;
			String email=randomString()+"@gmail.com";
			addcuts.custemail(email);
			addcuts.custpassword("202514");
			addcuts.custsubmit();
			addcuts.custcontinue();
			
			
		Thread.sleep(10000);
	
	

	boolean res=	driver.getPageSource().contains("customer registered succesfully!!!");
		if(res==false) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"TC_Addcustomerpage_003");
			Assert.assertTrue(false);         
		}
		
		
	}
}
	

