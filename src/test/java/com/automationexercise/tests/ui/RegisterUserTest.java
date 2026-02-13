package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class RegisterUserTest extends BaseTest {

    @Test(description = "TC1: Register User")
    @Description("Launch browser → Register new user → Verify success → Check logged in → Delete account → Verify deletion")
    public void testRegisterUserFullFlow() {
        String name = "User" + new Random().nextInt(100000);
        String email = "auto" + System.currentTimeMillis() + "@test.ge";
        String password = "Test123!";


        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Step 3: Home page is not visible");


        homePage.clickSignupLogin();


        SignupLoginPage signupLoginPage = new SignupLoginPage(getDriver());
        Assert.assertTrue(signupLoginPage.isNewUserSignupVisible(), "Step 5: 'New User Signup!' is not visible");


        signupLoginPage.enterNameAndEmail(name, email);


        signupLoginPage.clickSignup();


        AccountInfoPage accountInfoPage = new AccountInfoPage(getDriver());
        Assert.assertTrue(accountInfoPage.isEnterAccountInfoVisible(), "Step 8: 'ENTER ACCOUNT INFORMATION' is not visible");


        accountInfoPage.fillAccountDetails(
                "Mr",
                password,
                "15",
                "May",
                "1995",
                true,
                true,
                "FirstName",
                "LastName",
                "Company XYZ",
                "Street 123",
                "Apt 45",
                "United States",
                "California",
                "Los Angeles",
                "90001",
                "+995551234567"
        );


        accountInfoPage.clickCreateAccount();


        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(getDriver());
        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible(), "Step 14: 'ACCOUNT CREATED!' is not visible");


        accountCreatedPage.clickContinue();


        Assert.assertTrue(homePage.isLoggedInAsVisible(name), "Step 16: 'Logged in as username' is not visible");


        homePage.clickDeleteAccount();


        AccountDeletedPage deletedPage = new AccountDeletedPage(getDriver());
        Assert.assertTrue(deletedPage.isAccountDeletedVisible(), "Step 18: 'ACCOUNT DELETED!' is not visible");

        deletedPage.clickContinue();


        Assert.assertTrue(homePage.isHomePageVisible(), "After deletion, home page should be visible again");
    }
}