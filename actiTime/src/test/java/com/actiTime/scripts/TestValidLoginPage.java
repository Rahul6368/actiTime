package com.actiTime.scripts;

import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;

public class TestValidLoginPage extends BaseTest{
	
	@Test
	public void test_ValidLogin(){
		
		String un = FWUtils.read_XL_Data(READ_XL_DATA, "ValidLoginPage", 1, 0);
		String pw = FWUtils.read_XL_Data(READ_XL_DATA, "ValidLoginPage", 1, 1);
		String expectedTitleETP = FWUtils.read_XL_Data(READ_XL_DATA, "ValidLoginPage", 1, 2);
		
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		FWUtils.verifyPageTitle(driver,expectedTitleETP);
		etp.clickOnLogOutLink();
	}
}