package com.automationexercise.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        captureScreenshot(result);
    }

    private void captureScreenshot(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = getDriver(testClass);

        if (driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(screenshot);
                System.out.println("Screenshot captured successfully");
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is null, cannot capture screenshot");
        }
    }

    private WebDriver getDriver(Object testClass) {
        try {
            java.lang.reflect.Field driverField = testClass.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            WebDriver driver = (WebDriver) driverField.get(testClass);
            System.out.println("Driver retrieved: " + (driver != null ? "SUCCESS" : "NULL"));
            return driver;
        } catch (Exception e) {
            System.out.println("Could not get driver: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png", fileExtension = ".png")
    public byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}