package com.actiTime.scripts;

import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.LoginPage;

public class TestInvalidLoginpage extends BaseTest {
	
	@Test
	public void test_InvalidLoginPage() throws InterruptedException {
		
		int rowCount = FWUtils.read_XL_RowCount(READ_XL_DATA, "InvalidLoginPage");
		
		LoginPage lp =new LoginPage(driver);
		
		for(int i=1;i<=rowCount;i++) {
			String un = FWUtils.read_XL_Data(READ_XL_DATA, "InvalidLoginPage", i, 0);
			String pw = FWUtils.read_XL_Data(READ_XL_DATA, "InvalidLoginPage", i, 1);
			
			lp.setUsername(un);
			lp.setPassword(pw);
			lp.clickOnLoginBTN();
			Thread.sleep(1000);
			lp.verifyErrMSg(driver);
		}
	}
}