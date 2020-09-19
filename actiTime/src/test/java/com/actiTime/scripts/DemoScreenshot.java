package com.actiTime.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;

public class DemoScreenshot extends BaseTest{

	@Test
	public void test_FailureScreenshot() {
		Assert.fail();
	}
}