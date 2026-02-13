package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BasePage {

    // Locators
    private final By getInTouchHeader   = By.xpath("//h2[text()='Get In Touch']");
    private final By nameInput          = By.name("name");
    private final By emailInput         = By.name("email");
    private final By subjectInput       = By.name("subject");
    private final By messageTextarea    = By.name("message");
    private final By uploadFileInput    = By.name("upload_file");
    private final By submitButton       = By.name("submit");
    private final By successMessage     = By.xpath("//div[@class='status alert alert-success']");
    private final By homeButton         = By.xpath("//a[@class='btn btn-success']");   // your original locator

    // Constructor
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGetInTouchVisible() {
        return isDisplayed(getInTouchHeader);
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        sendKeys(nameInput, name);
        sendKeys(emailInput, email);
        sendKeys(subjectInput, subject);
        sendKeys(messageTextarea, message);
    }

    public void uploadFile(String filePath) {
        sendKeys(uploadFileInput, filePath);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }


    public void clickHomeButtonWithJS() {
        WebElement homeBtn = driver.findElement(homeButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", homeBtn);
    }


    public By getSuccessMessageLocator() {
        return successMessage;
    }
}