package com.automationexercise.tests.api;

import com.automationexercise.api.endpoints.UserAPI;
import com.automationexercise.base.BaseAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAPITest extends BaseAPI {

    private String testEmail = "testuser" + System.currentTimeMillis() + "@test.com";
    private String testPassword = "Test@123";

    @Test(priority = 1)
    @Description("API 11: POST To Create/Register User Account")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateAccount() {
        Response response = UserAPI.createAccount(
                "Test User",
                testEmail,
                testPassword,
                "Mr",
                "15",
                "May",
                "1990",
                "John",
                "Doe",
                "Test Company",
                "123 Test Street",
                "Apt 4B",
                "United States",
                "12345",
                "California",
                "Los Angeles",
                "1234567890"
        );

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 201,
                "Response code should be 201");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "User created!",
                "Message should confirm user created");

        System.out.println("User created: " + testEmail);
    }

    @Test(priority = 2, dependsOnMethods = "testCreateAccount")
    @Description("API 7: POST To Verify Login with valid details")
    @Severity(SeverityLevel.CRITICAL)
    public void testVerifyLoginValid() {
        Response response = UserAPI.verifyLogin(testEmail, testPassword);

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200,
                "Response code should be 200");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "User exists!",
                "Message should confirm user exists");

        System.out.println("Login successful: " + message);
    }

    @Test(priority = 3)
    @Description("API 14: GET user account detail by email")
    @Severity(SeverityLevel.NORMAL)
    public void testGetUserDetailByEmail() {
        Response response = UserAPI.getUserDetailByEmail("ararsebuli@gmail.com");

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200,
                "Response code should be 200");

        Assert.assertNotNull(response.jsonPath().get("user"),
                "User details should not be null");

        String email = response.jsonPath().getString("user.email");
        Assert.assertEquals(email, "ararsebuli@gmail.com",
                "Email should match the created user");

        System.out.println("User details retrieved for: " + email);
        response.jsonPath().prettyPrint();

    }

    @Test(priority = 4, dependsOnMethods = "testCreateAccount")
    @Description("API 13: DELETE To Verify Account Deleted")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteAccount() {
        Response response = UserAPI.deleteAccount(testEmail, testPassword);

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200,
                "Response code should be 200");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Account deleted!",
                "Message should confirm account deleted");

        System.out.println("Account deleted: " + testEmail);
    }

    @Test(priority = 5)
    @Description("API 8: POST To Verify Login without email parameter")
    @Severity(SeverityLevel.NORMAL)
    public void testVerifyLoginWithoutEmail() {
        Response response = UserAPI.verifyLoginWithoutEmail("somepassword");

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 400,
                "Response code should be 400");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Bad request, email or password parameter is missing in POST request.",
                "Message should indicate missing parameter");

        System.out.println("Error message: " + message);
    }

    @Test(priority = 6)
    @Description("API 10: POST To Verify Login with invalid details")
    @Severity(SeverityLevel.NORMAL)
    public void testVerifyLoginInvalidCredentials() {
        Response response = UserAPI.verifyLoginInvalidCredentials("invalid@test.com", "wrongpassword");

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 404,
                "Response code should be 404");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "User not found!",
                "Message should indicate user not found");

        System.out.println("Error message: " + message);
    }
}
