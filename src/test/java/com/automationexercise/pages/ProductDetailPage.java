package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    private final By productInfoContainer = By.cssSelector("div.product-information");
    private final By productName = By.cssSelector("div.product-information h2");
    private final By category = By.xpath("//div[@class='product-information']//p[contains(text(),'Category:')]");
    private final By price = By.cssSelector("div.product-information span span");
    private final By availability = By.xpath("//div[@class='product-information']//p[b[text()='Availability:']]");
    private final By condition = By.xpath("//div[@class='product-information']//p[b[text()='Condition:']]");
    private final By brand = By.xpath("//div[@class='product-information']//p[b[text()='Brand:']]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify product detail page is loaded")
    public boolean isDetailPageLoaded() {
        return isDisplayed(productInfoContainer) && isDisplayed(productName);
    }

    @Step("Verify product name is visible")
    public boolean isProductNameVisible() {
        return isDisplayed(productName);
    }

    @Step("Verify category is visible")
    public boolean isCategoryVisible() {
        return isDisplayed(category);
    }

    @Step("Verify price is visible")
    public boolean isPriceVisible() {
        return isDisplayed(price);
    }

    @Step("Verify availability is visible")
    public boolean isAvailabilityVisible() {
        return isDisplayed(availability);
    }

    @Step("Verify condition is visible")
    public boolean isConditionVisible() {
        return isDisplayed(condition);
    }

    @Step("Verify brand is visible")
    public boolean isBrandVisible() {
        return isDisplayed(brand);
    }
}