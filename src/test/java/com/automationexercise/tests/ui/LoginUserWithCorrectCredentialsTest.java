package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class LoginUserWithCorrectCredentialsTest extends BaseTest {


    private static final String VALID_EMAIL    = "lukaluka@mail.ru";
    private static final String VALID_PASSWORD = "lukaluka@mail.ru";
    private static final String EXPECTED_NAME  = "lukaluka";

    @Test(description = "TC2: Login User with correct email and password")
    @Description("Login with valid pre-existing credentials → verify success → optional delete")
    public void testLoginWithCorrectCredentials() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Step 3: Home page not visible");

        homePage.clickSignupLogin();

        SignupLoginPage page = new SignupLoginPage(getDriver());
        Assert.assertTrue(page.isLoginToYourAccountVisible(), "Step 5: 'Login to your account' missing");


        page.enterLoginEmailAndPassword(VALID_EMAIL, VALID_PASSWORD);
        page.clickLoginButton();


        Assert.assertTrue(homePage.isLoggedInAsVisible(EXPECTED_NAME),
                "Step 8: 'Logged in as " + EXPECTED_NAME + "' not visible after login");


    }
}