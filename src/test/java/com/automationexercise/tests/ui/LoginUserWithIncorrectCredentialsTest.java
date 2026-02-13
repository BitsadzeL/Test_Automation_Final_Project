package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class LoginUserWithIncorrectCredentialsTest extends BaseTest {


    private static final String WRONG_EMAIL    = "thisdoesnotexist999999@test.ge";
    private static final String WRONG_PASSWORD = "WrongPass999!";

    @Test(description = "TC3: Login User with incorrect email and password")
    @Description("Attempt login with invalid credentials → verify error message appears")
    public void testLoginWithIncorrectCredentials() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Step 3: Home page is not visible");


        homePage.clickSignupLogin();


        SignupLoginPage signupLoginPage = new SignupLoginPage(getDriver());
        Assert.assertTrue(signupLoginPage.isLoginToYourAccountVisible(),
                "Step 5: 'Login to your account' is not visible");

        signupLoginPage.enterLoginEmailAndPassword(WRONG_EMAIL, WRONG_PASSWORD);


        signupLoginPage.clickLoginButton();


        By errorMessageLocator = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");


        Assert.assertTrue(isDisplayed(errorMessageLocator),
                "Step 8: Error message 'Your email or password is incorrect!' is not visible");


        System.out.println("Negative login test passed - error message detected");
    }


    private boolean isDisplayed(By locator) {
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}