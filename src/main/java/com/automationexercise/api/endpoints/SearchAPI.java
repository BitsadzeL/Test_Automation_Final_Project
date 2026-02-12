package com.automationexercise.api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class SearchAPI {

    public static Response searchProduct(String searchTerm) {
        return given()
                .formParam("search_product", searchTerm)
                .when()
                .post("/searchProduct")
                .then()
                .extract()
                .response();
    }

    public static Response searchProductWithoutParameter() {
        return given()
                .when()
                .post("/searchProduct")
                .then()
                .extract()
                .response();
    }
}