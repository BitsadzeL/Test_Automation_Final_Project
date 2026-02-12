package com.automationexercise.api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserAPI {

    public static Response verifyLogin(String email, String password) {
        return given()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/verifyLogin")
                .then()
                .extract()
                .response();
    }

    public static Response verifyLoginWithoutEmail(String password) {
        return given()
                .formParam("password", password)
                .when()
                .post("/verifyLogin")
                .then()
                .extract()
                .response();
    }

    public static Response verifyLoginInvalidCredentials(String email, String password) {
        return given()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/verifyLogin")
                .then()
                .extract()
                .response();
    }

    public static Response createAccount(String name, String email, String password, String title,
                                         String birthDate, String birthMonth, String birthYear,
                                         String firstName, String lastName, String company,
                                         String address1, String address2, String country,
                                         String zipcode, String state, String city, String mobileNumber) {
        return given()
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("title", title)
                .formParam("birth_date", birthDate)
                .formParam("birth_month", birthMonth)
                .formParam("birth_year", birthYear)
                .formParam("firstname", firstName)
                .formParam("lastname", lastName)
                .formParam("company", company)
                .formParam("address1", address1)
                .formParam("address2", address2)
                .formParam("country", country)
                .formParam("zipcode", zipcode)
                .formParam("state", state)
                .formParam("city", city)
                .formParam("mobile_number", mobileNumber)
                .when()
                .post("/createAccount")
                .then()
                .extract()
                .response();
    }

    public static Response getUserDetailByEmail(String email) {
        return given()
                .queryParam("email", email)
                .when()
                .get("/getUserDetailByEmail")
                .then()
                .extract()
                .response();
    }

    public static Response deleteAccount(String email, String password) {
        return given()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/deleteAccount")
                .then()
                .extract()
                .response();
    }
}