package com.automationexercise.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automationexercise.utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;  // Changed from public to protected

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver("chrome");
        driver = DriverFactory.getDriver();
        driver.get("https://automationexercise.com");
    }

    @AfterMethod
    public void tearDown() {
        // Driver will be closed here AFTER screenshot is taken
        DriverFactory.quitDriver();
    }
}