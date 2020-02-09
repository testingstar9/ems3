package com.ems.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
public WebDriver ldriver;
	
	public SignUpPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="contactFName")
	WebElement txtFName;
	
	@FindBy(id="contactLname")
	WebElement txtLName;
	
	@FindBy(id="emailId")
	WebElement txtEmail;
	
	@FindBy(id="employeePhone")
	WebElement numberMobile;
	
	@FindBy(id="password")
	WebElement txtPassword1;
	
	@FindBy(id="password2")
	WebElement txtPassword2;
	
	@FindBy(xpath="//input[@value='Register']")
	WebElement btnSignup;
	
	

	

	public void setFirstName(String fname)
	{
		txtFName.sendKeys(fname);
	}
		
	
	public void setLastName(String lname)
	{
		txtLName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setMobileNumber(String mobile)
	{
		numberMobile.sendKeys(mobile);
	}
		
	public void setPassword1(String pwd)
	{
		txtPassword1.sendKeys(pwd);
	}
	
	public void setPassword2(String pwd)
	{
		txtPassword2.sendKeys(pwd);
	}
		
	public void clickSignup()
	{
		btnSignup.click();
	}
	
	
	
}


