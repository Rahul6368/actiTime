package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class EnterTimeTrackPage
{	
	
	@FindBy(xpath="//div[text()='TASKS']/parent::a[@class='content tasks']")
	private WebElement taskTab;
	
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settingsMenu;
	
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement licensesLink;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnTaskTab()
	{
		taskTab.click();
	}
	public void clickOnSettingsMenu()
	{
		settingsMenu.click();
	}
	
	public void clickOnLicensesLink()
	{
		licensesLink.click();
	}
	
	public void clickOnLogOutLink()
	{
		logoutLink.click();
	}	
}
