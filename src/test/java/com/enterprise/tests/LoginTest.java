package com.enterprise.tests;

import org.testng.annotations.Test;

import com.enterprise.base.BaseTest;
import com.enterprise.pages.LoginPage;
import org.testng.Assert;
import com.enterprise.pages.DashboardPage;
import com.enterprise.utilities.BrowserUtils;
import com.enterprise.utilities.ScreenshotUtils;
import com.enterprise.utilities.DataProviderUtils;
import com.enterprise.utilities.RetryAnalyzer;


public class LoginTest extends BaseTest {
	
	     
	
	@Test(dataProvider = "loginData",
		    dataProviderClass = DataProviderUtils.class,
		    retryAnalyzer = RetryAnalyzer.class)
	      
	      public void loginTest(String username, String password, String expectedResult)  {

	    	  LoginPage login = new LoginPage(getDriver());

	    	  DashboardPage dashboard = new DashboardPage(getDriver());
	    	  
              login.login(username, password);

	    	  if (expectedResult.equalsIgnoreCase("PASS")) {

	    	      Assert.assertTrue(dashboard.isDashboardDisplayed());

	    	      ScreenshotUtils.captureScreenshot(getDriver(), "SuccessfulLogin");

	    	  } else {

	    	      Assert.assertFalse(dashboard.isDashboardDisplayed());

	    	      ScreenshotUtils.captureScreenshot(getDriver(), "FailedLogin");

	    	  }
	    	  
	      }    	  
}