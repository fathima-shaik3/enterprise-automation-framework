package com.enterprise.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.enterprise.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.enterprise.utilities.BrowserFactory;

public class BaseTest {
	
	private static final Logger logger =
	        LogManager.getLogger(BaseTest.class);
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    ConfigReader config = new ConfigReader();
    
    
    public static WebDriver getDriver() {
        return driver.get();
    }
    

    @BeforeMethod
    public void setup() {

        try {

            logger.info("Launching browser");
            System.out.println(
            	    "Thread ID: " + Thread.currentThread().getId()
            	);

            String browser = config.getProperty("browser");

            driver.set(BrowserFactory.createDriver(browser));

            driver.get().manage().window().maximize();

            driver.get().get(config.getProperty("url"));

            logger.info("Navigated to OrangeHRM");

        } catch (Exception e) {

            e.printStackTrace();
            throw e;

        }
    }

    @AfterMethod
    public void tearDown() {

        logger.info("Closing browser");

        driver.get().quit();
        driver.remove();
    }
}