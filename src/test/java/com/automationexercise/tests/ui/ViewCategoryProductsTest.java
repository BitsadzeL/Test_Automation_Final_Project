package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.CategoryProductsPage;
import com.automationexercise.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.utils.DriverFactory.getDriver;

public class ViewCategoryProductsTest extends BaseTest {

    @Test(description = "TC 18: View Category Products – Women → Dress, then Men → Tshirts")
    public void testViewCategoryProducts() {

        HomePage homePage = new HomePage(getDriver());
        CategoryProductsPage categoryPage = new CategoryProductsPage(getDriver());


        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");


        homePage.navigateToProductsPage();


        Assert.assertTrue(homePage.isCategorySidebarVisible(),
                "Left sidebar categories are not visible");


        homePage.expandWomenCategory();
        homePage.clickDressSubcategory();


        Assert.assertTrue(categoryPage.isCategoryPageVisible(),
                "Category products page did not load");
        categoryPage.verifyWomenDressTitle();


        homePage.expandMenCategory();
        homePage.clickTshirtsSubcategory();


        Assert.assertTrue(categoryPage.isCategoryPageVisible(),
                "Men category products page did not load");
        categoryPage.verifyMenTshirtsTitle();

        System.out.println("TC 18 PASSED - Successfully verified both category navigations");
    }
}