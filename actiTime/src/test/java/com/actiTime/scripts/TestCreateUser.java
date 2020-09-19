package com.actiTime.scripts;

import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.TaskListPage;

public class TestCreateUser extends BaseTest{
	
	@Test
	public void test_CreateUser() throws InterruptedException	{
       
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,"actiTIME - Enter Time-Track");
		etp.clickOnTaskTab();
		
		TaskListPage tls = new TaskListPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,"actiTIME - Task List");
		tls.clickOnAddNewBTN();
		tls.clickOnPlusNwCustomer();
		Thread.sleep(1000);
		tls.setNewCustomerName("B565217");
		tls.clickonPlusCreateCusomerBTN();
		tls.listofCustomers();
		etp.clickOnLogOutLink();
		
	}
}
