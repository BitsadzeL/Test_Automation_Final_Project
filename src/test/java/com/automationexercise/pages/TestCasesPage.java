package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private final By testCasesTitle = By.xpath("//h2[b[text()='Test Cases']]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'Test Cases' page is visible")
    public boolean isTestCasesPageVisible() {
        return isDisplayed(testCasesTitle);
    }
}