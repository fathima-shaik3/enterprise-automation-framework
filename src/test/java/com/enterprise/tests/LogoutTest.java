package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.base.BaseTest;
import com.enterprise.pages.DashboardPage;
import com.enterprise.pages.LoginPage;
import com.enterprise.utilities.ConfigReader;

public class LogoutTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    @Test
    public void logoutTest() {

        LoginPage login = new LoginPage(getDriver());
        		

        login.login(
                config.getProperty("username"),
                config.getProperty("password"));

        DashboardPage dashboard = new DashboardPage(getDriver());

        Assert.assertTrue(dashboard.isDashboardDisplayed());

        dashboard.logout();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("login"));
    }
}
