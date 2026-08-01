
package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;

    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By profileMenu = By.className("oxd-userdropdown-tab");

    By logout = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));

            return driver.findElement(dashboardHeader).isDisplayed();

        }
        catch (org.openqa.selenium.TimeoutException e) {
        	
        }
            return false;
        }
    public void logout() {

        driver.findElement(profileMenu).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));

        driver.findElement(logout).click();
    }
    
}