package com.enterprise.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

    	if (browser.equalsIgnoreCase("chrome")) {
    	    return new ChromeDriver();

    	} else if (browser.equalsIgnoreCase("edge")) {

    	    EdgeOptions options = new EdgeOptions();
    	    return new EdgeDriver(options);

    	} else {
    	    throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

    }   
}