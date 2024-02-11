package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver ldriver;   //webriver object
	
	 public loginpage(WebDriver rdriver)        //parameterized constructor for intializing the webdriver
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Elements on Login page 
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtuser;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement logout;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[1]/a/img")
	@CacheLookup
	WebElement checklogo;
	
	//Set Actions Method on web Element
	
	public void setusername(String uname) {
		txtuser.sendKeys(uname);
	}
	
		
	public void setpassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void clicksubmit() {
		login.click();
	}
	
	public void clicklogout() {
		logout.click();
	}
	
	public void checklogo() {
		checklogo.isDisplayed();
	}

	

}
