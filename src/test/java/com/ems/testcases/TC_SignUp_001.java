package com.ems.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ems.pageobjects.SignUpPage;
import com.ems.utils.ExcelUtils;

public class TC_SignUp_001 extends TestCaseBase{

	@Test(dataProvider="SignupData")
	public void signUpTest(String fname, String lname,String email, String mnumber,String pwd1, String pwd2) throws InterruptedException, IOException {
		
		driver.get(baseURL);
		logger.info("application url opened");
		
		SignUpPage sp = new SignUpPage(driver);
		sp.setFirstName(fname);
		logger.info("first name provided");
		
		sp.setLastName(lname);
		logger.info("last name provided");
		
		sp.setEmail(email);
		logger.info("email provided");
		
		sp.setMobileNumber(mnumber);
		logger.info("mobile number provided");
		
		sp.setPassword1(pwd1);
		logger.info("password provided");
		
		sp.setPassword2(pwd2);
		logger.info("confirm password provided");

	}
	
	@DataProvider(name="SignupData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/ems/testdata/SignUpData.xlsx";
		
		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colcount=ExcelUtils.getCellCount(path,"Sheet1",1);
		System.out.println(rownum);
		System.out.println(colcount);
		
		String signupdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				signupdata[i-1][j]=ExcelUtils.getCellData(path,"Sheet1", i,j);
				if(driver.getTitle().equals("Employee Management App Registration")) {
					System.out.println("passed");
					ExcelUtils.setCellData(path, "sheet1", i, 7, "passed");
			}
				else {
					System.out.println("failed");
					ExcelUtils.setCellData(path, "sheet1", i, 7, "failed");
				}
				//driver.findElement(By.linkText("login")).click();
			}
			
		}
		//driver.findElement(By.linkText("login")).click();
		return signupdata;
		
	}
	
	
}