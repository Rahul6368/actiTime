package com.actiTime.scripts;

import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LicencesPage;
import com.actiTime.pages.LoginPage;

public class TestIssuesDate extends BaseTest {
	
	@Test
	public void test_IssueDate() throws InterruptedException 
	{	
		
		String un = FWUtils.read_XL_Data(READ_XL_DATA, "CheckIssueDate", 1, 0);
		String pw = FWUtils.read_XL_Data(READ_XL_DATA, "CheckIssueDate", 1, 1);
		String expectedTitleETP = FWUtils.read_XL_Data(READ_XL_DATA, "CheckIssueDate", 1, 2);
		String expectedTitleLCP = FWUtils.read_XL_Data(READ_XL_DATA, "CheckIssueDate", 1, 3);
		String expectedTitleIssueDate = FWUtils.read_XL_Data(READ_XL_DATA, "CheckIssueDate", 1, 4);
		
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,expectedTitleETP);
		etp.clickOnSettingsMenu();
		etp.clickOnLicensesLink();
		
		LicencesPage lcp = new LicencesPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,expectedTitleLCP);
		lcp.verifyIssueDate(expectedTitleIssueDate);
		etp.clickOnLogOutLink();
	}
}