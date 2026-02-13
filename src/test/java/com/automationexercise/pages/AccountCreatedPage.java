package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedHeader = By.xpath("//b[text()='Account Created!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedVisible() {
        return isDisplayed(accountCreatedHeader);
    }

    public void clickContinue() {
        click(continueButton);
    }
}