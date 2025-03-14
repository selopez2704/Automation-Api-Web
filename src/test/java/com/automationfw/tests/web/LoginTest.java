package com.automationfw.tests.web;

import static com.automationfw.data.Constants.PRODUCT_PAGE_TITLE;

import com.automationfw.data.DataTestProvider;
import com.automationfw.tests.BaseTest;
import com.automationfw.web.pages.LoginPage;
import com.automationfw.web.pages.ProductsPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class LoginTest extends BaseTest {

  @Test(dataProvider = "valid-login", dataProviderClass = DataTestProvider.class)
  public void validLoginTest(String username, String password) {
    LoginPage loginPage = new LoginPage();
    loginPage.login(username, password);
    ProductsPage productsPage = new ProductsPage();
    Assert.assertEquals(productsPage.getTitle().getText(), PRODUCT_PAGE_TITLE.getName(),
      "Login fail the Products page is not displayed");
  }

  @Test(dataProvider = "locked-login", dataProviderClass = DataTestProvider.class)
  public void lockedLoginTest(String username, String password) {
    LoginPage loginPage = new LoginPage();
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.isLoginFailed());
  }
}
