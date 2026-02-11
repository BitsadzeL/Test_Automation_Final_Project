package com.automationexercise.api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ProductAPI {

    public static Response getAllProducts() {
        return given()
                .when()
                .get("/productsList")
                .then()
                .extract()
                .response();
    }
}