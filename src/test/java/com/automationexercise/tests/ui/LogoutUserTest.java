package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class LogoutUserTest extends BaseTest {



    private static final String VALID_EMAIL    = "lukaluka@mail.ru";
    private static final String VALID_PASSWORD = "lukaluka@mail.ru";
    private static final String EXPECTED_NAME  = "lukaluka";

    @Test(description = "TC4: Logout User")
    @Description("Login → logout → verify back on login page")
    public void testLogoutUser() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        homePage.clickSignupLogin();

        SignupLoginPage loginPage = new SignupLoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginToYourAccountVisible(),
                "'Login to your account' not visible before login");

        loginPage.enterLoginEmailAndPassword(VALID_EMAIL, VALID_PASSWORD);
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.isLoggedInAsVisible(EXPECTED_NAME),
                "'Logged in as ...' not visible after login");


        homePage.clickLogout();


        Assert.assertTrue(loginPage.isLoginToYourAccountVisible(),
                "After logout, login page did not appear");


    }
}