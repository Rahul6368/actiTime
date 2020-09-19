package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LicencesPage
{
	
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]")
	private WebElement productEdition;
	
	@FindBy(xpath="//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issueDate;
	
	public LicencesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
		
	public void verifyProductEdition(String expectedProductEdition){
		
		String actualProductEdition =productEdition.getText();
		if(actualProductEdition.equals(expectedProductEdition))
		{
			System.out.println("The Expected productEdition is Dispalyed--->"+expectedProductEdition);
			System.out.println("TestCase Is passed");
		}
		else
		{
			System.out.println("The Expected productEdition is not Dispalyed--->"+actualProductEdition);
			System.out.println("TestCase Is Failed");
		}
	}
	
	public void verifyIssueDate(String expectedIssueDate){
		
		String actualIssueDate =issueDate.getText();
		if(actualIssueDate.equals(expectedIssueDate))
		{
			System.out.println("The Expected IssueDate is Dispalyed--->"+expectedIssueDate);
			System.out.println("TestCase Is passed");
		}
		else
		{
			System.out.println("The Expected IssueDate is not Dispalyed--->"+actualIssueDate);
			System.out.println("TestCase Is Failed");
		}
	}
	

}
