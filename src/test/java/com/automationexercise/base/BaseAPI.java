package com.automationexercise.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPI {

    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }
}
