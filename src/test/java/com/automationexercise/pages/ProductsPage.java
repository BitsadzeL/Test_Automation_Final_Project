package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage {


    private final By allProductsHeader = By.xpath("//h2[text()='All Products']");


    private final By productCards = By.cssSelector(".features_items .col-sm-4");


    private final By firstViewProductLink = By.xpath("(//a[contains(@href, '/product_details/')])[1]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies that the "All Products" page is displayed
     */
    public boolean isAllProductsPageVisible() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if at least one product is visible on the page
     */
    public boolean areProductsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));
            List<WebElement> products = driver.findElements(productCards);
            return products.size() >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clicks on "View Product" for the first product in the list
     * Includes wait + scroll to make sure it's clickable
     */
    public void clickFirstViewProduct() {

        wait.until(ExpectedConditions.presenceOfElementLocated(firstViewProductLink));

        WebElement link = driver.findElement(firstViewProductLink);


        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", link);


        wait.until(ExpectedConditions.elementToBeClickable(link));


        link.click();
    }


    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsHeader = By.xpath("//h2[text()='Searched Products']");

    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        sendKeys(searchInput, productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        click(searchButton);
    }

    public boolean isSearchedProductsVisible() {
        return isDisplayed(searchedProductsHeader);
    }



}