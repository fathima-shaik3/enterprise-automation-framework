package com.enterprise.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {

    public static void wait(int seconds) {

        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}