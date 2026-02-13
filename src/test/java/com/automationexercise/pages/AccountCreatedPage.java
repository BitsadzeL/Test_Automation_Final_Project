package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedHeader = By.xpath("//b[text()='Account Created!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'Account Created!' message is visible")
    public boolean isAccountCreatedVisible() {
        return isDisplayed(accountCreatedHeader);
    }

    @Step("Click Continue button")
    public void clickContinue() {
        click(continueButton);
    }
}