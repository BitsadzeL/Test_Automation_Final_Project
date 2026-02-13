package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {

    private final By accountDeletedHeader = By.xpath("//b[text()='Account Deleted!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'Account Deleted!' message is visible")
    public boolean isAccountDeletedVisible() {
        return isDisplayed(accountDeletedHeader);
    }

    @Step("Click Continue button")
    public void clickContinue() {
        click(continueButton);
    }
}