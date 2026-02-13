package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class VerifyAllProductsAndDetailPageTest extends BaseTest {

    @Test(description = "TC8: Verify All Products and product detail page")
    public void testAllProductsAndDetailPage() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "Not on All Products page");
        Assert.assertTrue(productsPage.areProductsVisible(), "No products visible");

        productsPage.clickFirstViewProduct();

        ProductDetailPage detailPage = new ProductDetailPage(getDriver());
        Assert.assertTrue(detailPage.isDetailPageLoaded(), "Product detail page not loaded");


        Assert.assertTrue(detailPage.isProductNameVisible(), "Product name missing");
        Assert.assertTrue(detailPage.isCategoryVisible(), "Category missing");
        Assert.assertTrue(detailPage.isPriceVisible(), "Price missing");
        Assert.assertTrue(detailPage.isAvailabilityVisible(), "Availability missing");
        Assert.assertTrue(detailPage.isConditionVisible(), "Condition missing");
        Assert.assertTrue(detailPage.isBrandVisible(), "Brand missing");

        System.out.println("TC8 FULLY PASSED – all details visible!");
    }
}