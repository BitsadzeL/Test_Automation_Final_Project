package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryProductsPage extends BasePage {

    private final By categoryTitle = By.xpath("//h2[@class='title text-center']");

    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify category page is visible")
    public boolean isCategoryPageVisible() {
        return isDisplayed(categoryTitle);
    }

    @Step("Get category title text")
    public String getCategoryTitleText() {
        return getText(categoryTitle).trim().toUpperCase();
    }

    @Step("Verify Women - Dress category title")
    public void verifyWomenDressTitle() {
        String title = getCategoryTitleText();
        Assert.assertTrue(title.contains("WOMEN") && title.contains("DRESS"),
                "Expected WOMEN - DRESS PRODUCTS, but got: " + title);
    }

    @Step("Verify Men - Tshirts category title")
    public void verifyMenTshirtsTitle() {
        String title = getCategoryTitleText();
        Assert.assertTrue(title.contains("MEN") && title.contains("TSHIRTS"),
                "Expected MEN - TSHIRTS PRODUCTS, but got: " + title);
    }
}