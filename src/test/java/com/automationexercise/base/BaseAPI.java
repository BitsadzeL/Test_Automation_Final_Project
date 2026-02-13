package com.automationexercise.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPI {

    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI = "https://automationexercise.com/api";
        RestAssured.filters(new AllureRestAssured());
    }
}