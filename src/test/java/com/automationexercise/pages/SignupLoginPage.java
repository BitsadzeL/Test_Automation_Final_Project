package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {

    private final By newUserSignupHeader = By.xpath("//h2[text()='New User Signup!']");
    private final By nameInput = By.name("name");
    private final By emailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewUserSignupVisible() {
        return isDisplayed(newUserSignupHeader);
    }

    public void enterNameAndEmail(String name, String email) {
        sendKeys(nameInput, name);
        sendKeys(emailInput, email);
    }

    public void clickSignup() {
        click(signupButton);
    }



    private final By loginToYourAccountHeader = By.xpath("//h2[text()='Login to your account']");
    private final By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");

    public boolean isLoginToYourAccountVisible() {
        return isDisplayed(loginToYourAccountHeader);
    }

    public void enterLoginEmailAndPassword(String email, String password) {
        sendKeys(loginEmailInput, email);
        sendKeys(loginPasswordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }



    private final By emailAlreadyExistError = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    public boolean isEmailAlreadyExistErrorVisible() {
        return isDisplayed(emailAlreadyExistError);
    }
}