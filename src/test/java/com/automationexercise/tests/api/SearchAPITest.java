package com.automationexercise.tests.api;

import com.automationexercise.api.endpoints.SearchAPI;
import com.automationexercise.base.BaseAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAPITest extends BaseAPI {

    @Test(priority = 1)
    @Description("API 5: POST To Search Product - Search for 'top'")
    @Severity(SeverityLevel.CRITICAL)
    public void testSearchProduct() {
        Response response = SearchAPI.searchProduct("top");


        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");


        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200,
                "Response code should be 200");


        int productsCount = response.jsonPath().getList("products").size();
        Assert.assertTrue(productsCount > 0,
                "Search should return at least one product");

        System.out.println("Search 'top' returned: " + productsCount + " products");
    }


    @Test(priority = 2)
    @Description("API 6: POST To Search Product without search_product parameter")
    @Severity(SeverityLevel.CRITICAL)
    public void testSearchProductWithoutParameter() {
        Response response = SearchAPI.searchProductWithoutParameter();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 400,
                "Response code should be 200");

        System.out.println("API returned 200 instead of documented 400");
    }

}
