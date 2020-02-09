package com.ems.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ems.utils.ReadConfig;

public class TestCaseBase {

	ReadConfig config = new ReadConfig();
	
	public String baseURL= config.getApplicationUrl();
	/**/
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		
		logger = Logger.getLogger("EMS");
		PropertyConfigurator.configure("./Configuration/log4j.properties");
		
		String chrome_driver = config.getChromeDriverPath();
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",chrome_driver);
			driver=new ChromeDriver();
		}
		
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",config.getIEDriverPath());
			driver=new InternetExplorerDriver();
		}
		
		
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",config.getFirefoxDriverPath());
			driver=new FirefoxDriver();
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
