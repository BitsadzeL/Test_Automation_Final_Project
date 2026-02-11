package com.automationexercise.tests.api;

import com.automationexercise.api.endpoints.ProductAPI;
import com.automationexercise.base.BaseAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAPITest extends BaseAPI {

    @Test(priority = 1)
    @Description("API 1: Get All Products List")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetAllProducts() {
        Response response = ProductAPI.getAllProducts();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");


        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200,
                "Response code should be 200");


        int productsCount = response.jsonPath().getList("products").size();
        Assert.assertTrue(productsCount > 0,
                "Products list should not be empty");

        System.out.println("Total products found: " + productsCount);
        System.out.println("Response: " + response.asString());
    }
}