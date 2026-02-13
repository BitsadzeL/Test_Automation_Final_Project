package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryProductsPage extends BasePage {

    private final By categoryTitle = By.xpath("//h2[@class='title text-center']");

    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCategoryPageVisible() {
        return isDisplayed(categoryTitle);
    }

    public String getCategoryTitleText() {
        return getText(categoryTitle).trim().toUpperCase();
    }

    public void verifyWomenDressTitle() {
        String title = getCategoryTitleText();
        Assert.assertTrue(title.contains("WOMEN") && title.contains("DRESS"),
                "Expected WOMEN - DRESS PRODUCTS, but got: " + title);
    }

    public void verifyMenTshirtsTitle() {
        String title = getCategoryTitleText();
        Assert.assertTrue(title.contains("MEN") && title.contains("TSHIRTS"),
                "Expected MEN - TSHIRTS PRODUCTS, but got: " + title);
    }
}