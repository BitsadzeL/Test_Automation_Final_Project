package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By fullFledgedText = By.xpath("//h2[contains(text(),'Full-Fledged practice website')]");
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccountLink = By.linkText("Delete Account");
    private final By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");
    private final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By productsLink = By.xpath("//a[@href='/products'] | //a[contains(.,'Products')]");

    private final By womenCategoryHeader = By.xpath("//a[contains(., 'Women') and @data-toggle='collapse']");
    private final By womenDressLink = By.xpath("//div[@id='Women']//a[contains(., 'Dress')]");
    private final By menCategoryHeader = By.xpath("//a[contains(., 'Men') and @data-toggle='collapse']");
    private final By menTshirtsLink = By.xpath("//div[@id='Men']//a[contains(., 'Tshirts')]");
    private final By productsLinkInHeader = By.xpath("//a[@href='/products']");
    private final By categorySidebarContainer = By.cssSelector("div.left-sidebar");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open homepage")
    public void open() {
        driver.get("https://automationexercise.com");
    }

    @Step("Verify homepage is visible")
    public boolean isHomePageVisible() {
        return isDisplayed(fullFledgedText);
    }

    @Step("Click Signup/Login link")
    public void clickSignupLogin() {
        click(signupLoginLink);
    }

    @Step("Verify logged in as: {username}")
    public boolean isLoggedInAsVisible(String username) {
        return getText(loggedInAs).contains(username);
    }

    @Step("Click Delete Account")
    public void clickDeleteAccount() {
        click(deleteAccountLink);
    }

    @Step("Click Logout")
    public void clickLogout() {
        click(logoutLink);
    }

    @Step("Click Contact Us")
    public void clickContactUs() {
        click(contactUsLink);
    }

    @Step("Click Test Cases")
    public void clickTestCases() {
        click(testCasesButton);
    }

    @Step("Click Products link")
    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink));
        driver.findElement(productsLink).click();
    }

    @Step("Navigate to Products page")
    public void navigateToProductsPage() {
        WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(productsLinkInHeader));
        productsLink.click();
        wait.until(ExpectedConditions.urlContains("/products"));
    }

    @Step("Verify category sidebar is visible")
    public boolean isCategorySidebarVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(categorySidebarContainer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Expand Women category")
    public void expandWomenCategory() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 350);");
        WebElement womenHeader = wait.until(ExpectedConditions.elementToBeClickable(womenCategoryHeader));
        womenHeader.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Women")));
    }

    @Step("Click Dress subcategory")
    public void clickDressSubcategory() {
        WebElement dressLink = wait.until(ExpectedConditions.elementToBeClickable(womenDressLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", dressLink);
        try {
            dressLink.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dressLink);
        }
    }

    @Step("Expand Men category")
    public void expandMenCategory() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
        WebElement menHeader = wait.until(ExpectedConditions.elementToBeClickable(menCategoryHeader));
        menHeader.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Men")));
    }

    @Step("Click Tshirts subcategory")
    public void clickTshirtsSubcategory() {
        WebElement tshirtsLink = wait.until(ExpectedConditions.elementToBeClickable(menTshirtsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", tshirtsLink);
        try {
            tshirtsLink.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tshirtsLink);
        }
    }
}