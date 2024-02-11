package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;


import com.inetbanking.pageobjects.EditCustomer;
import com.inetbanking.pageobjects.loginpage;

public class TC_Editcustomer_004 extends Baseclass {
	@Test(priority=1)
	public void editcustomer() throws InterruptedException, IOException {
		
		loginpage lp=new loginpage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicksubmit();  
		
		EditCustomer ed=new EditCustomer(driver);
		ed.clickeditcust();
		ed.getcustomerid("64871");
		ed.clicksubmit();
		Thread.sleep(10000);
		//ed.getcustname("DON");
		//ed.clicksubmit1();
	
		Thread.sleep(300);
	
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"TC_Editcustomer_004");  //(driver,"TestCaseName)
			Assert.assertTrue(false);
			Thread.sleep(300);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}          

	
	@Test(priority=3)
	public void checktitle() {
		
		if(driver.getTitle().equals("Guru99 Bank Edit Customer Page")) { 
			System.out.println(driver.getTitle());
		Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}
		driver.close();
	} 
	
    @Test(priority=2)
     public void gettitle() {
    	
		driver.getTitle();
    	
    }
    @Test
    public void checkHeader() {
    	EditCustomer ed=new EditCustomer(driver);
       	String header=ed.checkheader();
}
    @Test
    public void checklogo() {
    	EditCustomer ed=new EditCustomer(driver);
    	ed.checklogo();
    }
    
}
