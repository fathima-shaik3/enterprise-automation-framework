package com.enterprise.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.enterprise.reports.ExtentManager;
import com.enterprise.reports.ExtentTestManager;
import com.enterprise.base.BaseTest;
import com.enterprise.utilities.ScreenshotUtils;


public class ReportListener implements ITestListener {

    ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        ExtentTestManager.setTest(test);
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass("Test Passed");

    }
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

        try {

            String screenshotPath = ScreenshotUtils.captureScreenshot(
                    BaseTest.getDriver(),
                    result.getName());

            ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

    }
    
    
}

