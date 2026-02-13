package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class ContactUsFormTest extends BaseTest {

    @Test(description = "TC6: Contact Us Form")
    @Description("Fill Contact Us form → upload auto-created temp file → submit → accept alert → verify success → back to home")
    public void testContactUsForm() {

        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofMillis(300));  // tighter polling


        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Step 3: Home page is not visible");


        homePage.clickContactUs();


        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "Step 5: 'GET IN TOUCH' is not visible");


        contactUsPage.fillContactForm(
                "Luka Automation",
                "luka.test.contact." + System.currentTimeMillis() + "@example.com",
                "Test Subject - Automation Exercise",
                "Hello,\nThis is an automated test message.\nTesting file upload and form submission.\nThank you!"
        );


        String tempContent = """
            Automated test file for Contact Us form
            Generated on: %s
            Purpose: Verify file upload functionality in Automation Exercise
            """.formatted(LocalDateTime.now());

        Path tempFilePath;
        try {
            tempFilePath = Files.createTempFile("contact-us-test-upload-", ".txt");
            Files.writeString(tempFilePath, tempContent);
            System.out.println("Temporary upload file created: " + tempFilePath.toAbsolutePath());
        } catch (IOException e) {
            Assert.fail("Failed to create temporary upload file: " + e.getMessage());
            return;
        }


        contactUsPage.uploadFile(tempFilePath.toAbsolutePath().toString());


        tempFilePath.toFile().deleteOnExit();


        contactUsPage.clickSubmit();


        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
        } catch (Exception e) {
            Assert.fail("No alert appeared after submit or error handling alert: " + e.getMessage());
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                contactUsPage.getSuccessMessageLocator()));
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(),
                "Step 10: 'Success! Your details have been submitted successfully.' is not visible");


        contactUsPage.clickHomeButtonWithJS();


        wait.until(ExpectedConditions.urlContains("automationexercise.com/"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]")
        ));


        Assert.assertTrue(homePage.isHomePageVisible(),
                "Step 11: Did not land on home page after clicking Home button");

        System.out.println("Contact Us form test completed successfully!");
    }
}