package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class VerifyTestCasesPageTest extends BaseTest {

    @Test(description = "TC7: Verify navigation to Test Cases page")
    @Description("Go to Test Cases page and verify it's loaded")
    public void testVerifyTestCasesPage() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.clickTestCases();

        TestCasesPage testCasesPage = new TestCasesPage(getDriver());


        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(d -> testCasesPage.isTestCasesPageVisible());

        Assert.assertTrue(testCasesPage.isTestCasesPageVisible(),
                "Test Cases page did not load correctly");
    }
}