package com.actiTime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

abstract public class BaseTest2 implements IAutoConstant
{
	static
	{
		System.setProperty(CHROM_KEY,CHROM_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	public static WebDriver driver;
		
	@BeforeClass
	@Parameters("sBrowser")
	public void openBrowser(String sBrowser)
	{
		if(sBrowser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(sBrowser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void openApplication() {
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
