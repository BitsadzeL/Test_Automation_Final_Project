## Group members
Luka Bitsadze, Luka Afciauri, Luka Danelia

## Test Case Assignment & Mapping

We automated 10 UI test cases and 10 API test cases from https://automationexercise.com.

### Luka Aptsiauri
- ContactUsFormTest.java  
  → Test Case 6: Contact Us Form
- LoginUserWithCorrectCredentialsTest.java  
  → Test Case 2: Login User with correct email and password
- LoginUserWithIncorrectCredentialsTest.java  
  → Test Case 3: Login User with incorrect email and password
- LogoutUserTest.java  
  → Test Case 4: Logout User
- RegisterUserTest.java  
  → Test Case 1: Register User
- RegisterWithExistingEmailTest.java  
  → Test Case 5: Register User with existing email
- VerifyTestCasesPageTest.java  
  → Test Case 7: Verify Test Cases Page

### Luka Bitsadze
- ProductAPITest.java – testGetAllProducts()  
  → API 1: Get All Products List
- ProductAPITest.java – testPostToAllProducts()  
  → API 2: POST To All Products List (method not supported)
- SearchAPITest.java – testSearchProduct()  
  → API 5: POST To Search Product
- SearchAPITest.java – testSearchProductWithoutParameter()  
  → API 6: POST To Search Product without search_product parameter
- UserAPITest.java – testCreateAccount()  
  → API 11: POST To Create/Register User Account
- UserAPITest.java – testVerifyLoginValid()  
  → API 7: POST To Verify Login with valid details
- UserAPITest.java – testDeleteAccount()  
  → API 13: DELETE To Verify Account Deleted

### Luka Danelia
**UI test cases:**
- SearchProductTest.java  
  → Test Case 9: Search Product
- VerifyAllProductsAndDetailPageTest.java  
  → Test Case 8: Verify All Products and product detail page
- ViewCategoryProductsTest.java  
  → Test Case 18: View Category Products

**API test cases:**
- UserAPITest.java – testGetUserDetailByEmail()  
  → API 14: GET user account detail by email
- UserAPITest.java – testVerifyLoginWithoutEmail()  
  → API 8: POST To Verify Login without email parameter
- UserAPITest.java – testVerifyLoginInvalidCredentials()  
  → API 10: POST To Verify Login with invalid details


## Running Tests

### Run All Tests (API + UI)

**Using IntelliJ:**
1. Open Maven panel (right side of IntelliJ)
2. Expand "Lifecycle"
3. Double-click on "test"

**Using Command Line:**
```bash
mvn clean test
```

---

### Run Only API Tests

**Using IntelliJ:**
1. Right-click on `src/test/java/com/automationexercise/tests/api` folder
2. Select "Run 'Tests in 'api''"

---

### Run Only UI Tests

**Using IntelliJ:**
1. Right-click on `src/test/java/com/automationexercise/tests/ui` folder
2. Select "Run 'Tests in 'ui''"

---

## Generating Allure Reports

### Step 1: Run Tests
Execute tests using any of the methods above.

### Step 2: Generate Report

**Using IntelliJ:**
1. Open Maven panel (right side)
2. Expand "Plugins"
3. Expand "allure"
4. Double-click on "allure:serve"
5. Report opens automatically in browser
