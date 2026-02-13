package com.automationexercise.pages;

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

    public boolean isDetailPageLoaded() {

        return isDisplayed(productInfoContainer) && isDisplayed(productName);
    }

    public boolean isProductNameVisible() {
        return isDisplayed(productName);
    }

    public boolean isCategoryVisible() {
        return isDisplayed(category);
    }

    public boolean isPriceVisible() {
        return isDisplayed(price);
    }

    public boolean isAvailabilityVisible() {
        return isDisplayed(availability);
    }

    public boolean isConditionVisible() {
        return isDisplayed(condition);
    }

    public boolean isBrandVisible() {
        return isDisplayed(brand);
    }
}