package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class SearchProductTest extends BaseTest {

    private static final String SEARCH_TERM = "T-Shirt";

    @Test(description = "TC9: Search Product")
    public void testSearchProduct() {

        HomePage homePage = new HomePage(getDriver());


        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");


        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage(getDriver());


        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "Not navigated to All Products page");


        productsPage.searchForProduct(SEARCH_TERM);


        Assert.assertTrue(productsPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' header is not visible");


        Assert.assertTrue(productsPage.areProductsVisible(),
                "No products found after search – check if '" + SEARCH_TERM + "' exists on the site");

        System.out.println("TC9 PASSED: Search for '" + SEARCH_TERM + "' worked correctly");
    }
}