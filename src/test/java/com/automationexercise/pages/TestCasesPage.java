package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }


    private final By testCasesTitle = By.xpath("//h2[b[text()='Test Cases']]");



    public boolean isTestCasesPageVisible() {
        return isDisplayed(testCasesTitle);
    }
}