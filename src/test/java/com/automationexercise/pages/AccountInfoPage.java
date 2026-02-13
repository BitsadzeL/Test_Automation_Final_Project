package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage extends BasePage {

    private final By enterAccountInfoHeader = By.xpath("//b[text()='Enter Account Information']");

    private final By genderMr = By.id("id_gender1");
    private final By genderMrs = By.id("id_gender2");

    private final By passwordField = By.id("password");
    private final By daysDropdown = By.id("days");
    private final By monthsDropdown = By.id("months");
    private final By yearsDropdown = By.id("years");

    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileField = By.id("mobile_number");

    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    public AccountInfoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'Enter Account Information' header is visible")
    public boolean isEnterAccountInfoVisible() {
        return isDisplayed(enterAccountInfoHeader);
    }

    @Step("Fill account details with title: {title}, name: {firstName} {lastName}")
    public void fillAccountDetails(
            String title,
            String password,
            String day, String month, String year,
            boolean newsletter, boolean offers,
            String firstName, String lastName,
            String company, String address1, String address2,
            String country, String state, String city,
            String zipcode, String mobile) {

        if (title.equalsIgnoreCase("Mr")) {
            click(genderMr);
        } else {
            click(genderMrs);
        }

        sendKeys(passwordField, password);

        new Select(driver.findElement(daysDropdown)).selectByValue(day);
        new Select(driver.findElement(monthsDropdown)).selectByVisibleText(month);
        new Select(driver.findElement(yearsDropdown)).selectByValue(year);

        if (newsletter) click(newsletterCheckbox);
        if (offers) click(offersCheckbox);

        sendKeys(firstNameField, firstName);
        sendKeys(lastNameField, lastName);
        sendKeys(companyField, company);
        sendKeys(address1Field, address1);
        sendKeys(address2Field, address2);

        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);

        sendKeys(stateField, state);
        sendKeys(cityField, city);
        sendKeys(zipcodeField, zipcode);
        sendKeys(mobileField, mobile);
    }

    @Step("Click 'Create Account' button")
    public void clickCreateAccount() {
        click(createAccountButton);
    }
}