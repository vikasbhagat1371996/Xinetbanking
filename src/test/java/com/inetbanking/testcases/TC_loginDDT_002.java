package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;
import com.inetbanking.utilities.XLUtils;

public class TC_loginDDT_002 extends Baseclass{
	@SuppressWarnings("deprecation")
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
	loginpage lp=new loginpage(driver);
	lp.setusername(user);
	lp.setpassword(pwd);
	lp.clicksubmit();
	
	Thread.sleep(3000);
	
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		
	}
	else
	{
		captureScreen(driver,"TC_loginDDT_002");
		Assert.assertTrue(true);
		lp.clicklogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close  logout alert
		driver.switchTo().defaultContent();
		
		
	}
	

}
	public boolean isAlertPresent()//user defined method to check alert present or not
	{
	try {
		driver.switchTo().alert();
		return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
}
	
	@DataProvider(name="LoginData")  //name ="logindata these is name of data provider method.
	String [] [] getData() throws IOException   //getdata  method is used for read the data from excell file 
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "sheet1");    //call the method of getRowCount in xlutils class
		int colcount=XLUtils.getcellCount(path, "Sheet1",1);//call the method of cell count in xlutils method.
		
		String logindata[][]=new String[rownum][colcount];  //store the value of rownum and colcount in two dimensional array
		
		for(int i=1;i<=rownum;i++)  
		{
		
		for(int j=0;j<colcount;j++)//0r  for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtils.getcellData(path,"Sheet1", i,j);//1 0   //i-1 ...>because rowcount start from zero and colcount start from 1 
		}
		
	}
	return logindata;     //it return the logindata two dimensional array which store the actual value of two dimension arrays.
}
}



