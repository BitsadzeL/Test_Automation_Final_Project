package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {

    private final By newUserSignupHeader = By.xpath("//h2[text()='New User Signup!']");
    private final By nameInput = By.name("name");
    private final By emailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private final By loginToYourAccountHeader = By.xpath("//h2[text()='Login to your account']");
    private final By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");
    private final By emailAlreadyExistError = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'New User Signup!' header is visible")
    public boolean isNewUserSignupVisible() {
        return isDisplayed(newUserSignupHeader);
    }

    @Step("Enter name: {name} and email: {email}")
    public void enterNameAndEmail(String name, String email) {
        sendKeys(nameInput, name);
        sendKeys(emailInput, email);
    }

    @Step("Click Signup button")
    public void clickSignup() {
        click(signupButton);
    }

    @Step("Verify 'Login to your account' header is visible")
    public boolean isLoginToYourAccountVisible() {
        return isDisplayed(loginToYourAccountHeader);
    }

    @Step("Enter login email: {email} and password")
    public void enterLoginEmailAndPassword(String email, String password) {
        sendKeys(loginEmailInput, email);
        sendKeys(loginPasswordInput, password);
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Verify 'Email Address already exist!' error is visible")
    public boolean isEmailAlreadyExistErrorVisible() {
        return isDisplayed(emailAlreadyExistError);
    }
}