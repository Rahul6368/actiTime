package com.actiTime.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskListPage{
	
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBTN;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement plusNewCustomerBTN;
	
	@FindBy(id="customerLightBox_nameField")
	private WebElement EnterCustomerNameTB;
	
	@FindBy(xpath="//span[text()='Create Customer']")
	private WebElement plusCreateCustomerBTN;
	
	@FindBy(xpath="//div[@class='node customerNode notSelected collapsed']")
	private List<WebElement> allCustomersname;
	
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}	
	
	public void clickOnAddNewBTN()
	{
		addNewBTN.click();
	}
	public void clickOnPlusNwCustomer()
	{
		plusNewCustomerBTN.click();
	}
	public void setNewCustomerName(String custName)
	{
		EnterCustomerNameTB.sendKeys(custName);
	}
	public void clickonPlusCreateCusomerBTN()
	{
		plusCreateCustomerBTN.click();
	}
	public void listofCustomers()
	{
		int count = allCustomersname.size();
		System.out.println(count);
		for(WebElement cn:allCustomersname)
		{
			String s = cn.getText();
			System.out.println(s);
			if(s.equals("BPS1"))
			{
				System.out.println("Customer created Sucessfully");
			}
		}
	}

}
