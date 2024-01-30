package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {
	WebDriver ldriver;
	
	public EditCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this );
		
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement editcutomer;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")
	@CacheLookup
	WebElement custid;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement submit;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement custname;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement submit1;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]")
	@CacheLookup
	WebElement header;
	
	@FindBy(xpath="/html/body/div[2]/h2")
	@CacheLookup
	WebElement logo;
	
	
	public void clickeditcust() {
		editcutomer.click();
		
	}
	public void getcustomerid(String num) {
		custid.sendKeys(num);
	}
	
	public void clicksubmit() {
		submit.click();
			
	}
	public void getcustname(String uname) {
		custname.sendKeys(uname);
	}
	
	public void clicksubmit1() {
		submit1.click();
	}
	
	public String checkheader() {
		header.getText();
		return null;
	}
	public void checklogo() {
		logo.isDisplayed();
	}

}
