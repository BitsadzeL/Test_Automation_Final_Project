package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BasePage {

    private final By getInTouchHeader   = By.xpath("//h2[text()='Get In Touch']");
    private final By nameInput          = By.name("name");
    private final By emailInput         = By.name("email");
    private final By subjectInput       = By.name("subject");
    private final By messageTextarea    = By.name("message");
    private final By uploadFileInput    = By.name("upload_file");
    private final By submitButton       = By.name("submit");
    private final By successMessage     = By.xpath("//div[@class='status alert alert-success']");
    private final By homeButton         = By.xpath("//a[@class='btn btn-success']");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'Get In Touch' header is visible")
    public boolean isGetInTouchVisible() {
        return isDisplayed(getInTouchHeader);
    }

    @Step("Fill contact form with name: {name}, email: {email}")
    public void fillContactForm(String name, String email, String subject, String message) {
        sendKeys(nameInput, name);
        sendKeys(emailInput, email);
        sendKeys(subjectInput, subject);
        sendKeys(messageTextarea, message);
    }

    @Step("Upload file: {filePath}")
    public void uploadFile(String filePath) {
        sendKeys(uploadFileInput, filePath);
    }

    @Step("Click Submit button")
    public void clickSubmit() {
        click(submitButton);
    }

    @Step("Verify success message is visible")
    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }

    @Step("Click Home button using JavaScript")
    public void clickHomeButtonWithJS() {
        WebElement homeBtn = driver.findElement(homeButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", homeBtn);
    }

    public By getSuccessMessageLocator() {
        return successMessage;
    }
}