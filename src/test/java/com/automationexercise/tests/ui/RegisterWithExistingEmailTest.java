package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class RegisterWithExistingEmailTest extends BaseTest {



    private static final String EXISTING_EMAIL = "lukaluka@mail.ru";
    private static final String ANY_NAME = "lukaluka";

    @Test(description = "TC5: Register User with existing email")
    @Description("Attempt to register with already used email → verify error message")
    public void testRegisterWithExistingEmail() {

        HomePage homePage = new HomePage(getDriver());


        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Step 3: Home page is not visible");


        homePage.clickSignupLogin();

        SignupLoginPage signupLoginPage = new SignupLoginPage(getDriver());


        Assert.assertTrue(signupLoginPage.isNewUserSignupVisible(),
                "Step 5: 'New User Signup!' section is not visible");


        signupLoginPage.enterNameAndEmail(ANY_NAME, EXISTING_EMAIL);


        signupLoginPage.clickSignup();


        Assert.assertTrue(signupLoginPage.isEmailAlreadyExistErrorVisible(),
                "Step 8: Error 'Email Address already exist!' is not displayed");
    }
}