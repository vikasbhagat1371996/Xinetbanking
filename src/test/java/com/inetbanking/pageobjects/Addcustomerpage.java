package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Addcustomerpage {
	//variable.
	WebDriver ldriver;
	
	//These is the constructor which required for initialize the webelements.
	public Addcustomerpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a") 
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomername;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"customer\"]/tbody/tr[14]/td/a")
	@CacheLookup
	WebElement btncontinue;
	
	
	
	
	

public void clickAddNewCustomer()
{
	lnkAddNewCustomer.click();
}


	public void custName(String ename) 
	{
		txtCustomername.sendKeys(ename);
	}
	
	public void custgender(String egender)
	{
		rdGender.click();
	}
	
	public void custdob(String dd,String mm,String yy)
	{
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String eaddress) {
		txtaddress.sendKeys(eaddress);
	}
	
	public void custcity(String ecity) {
		txtcity.sendKeys(ecity);
	}
	
	public void custstate(String estate) {
		txtstate.sendKeys(estate);
	}
	
/*	public void custpinno(int epinno)    //if value of pin is in int format then sendkeys method that not accepted
	{ 	                                 //that time it convert to string using String.valueof epinno.
	txtpinno.sendKeys(String.valueOf(epinno));
	}  */
	//or
	public void custpinno(String epinno)    //if value of pin is in int format then sendkeys method that not accepted
	{ 	                                 //that time it convert to string using String.valueof epinno.
	txtpinno.sendKeys(epinno);
	}
	
	public void custmobilno(String emobileno) {
		txttelephoneno.sendKeys(emobileno);
	}
	
	public void custemail(String eemail) {
		txtemailid.sendKeys(eemail);
	}
	
	public void custpassword(String epassword) {
		txtpassword.sendKeys(epassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	

	public void custcontinue() {
		btncontinue.click();
	}
	
	
	
}
