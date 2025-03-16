package com.automationfw.tests.web;

import static com.automationfw.data.Constants.PRODUCT_PAGE_TITLE;

import com.automationfw.data.DataTestProvider;
import com.automationfw.tests.WebBaseTest;
import com.automationfw.web.pages.LoginPage;
import com.automationfw.web.pages.ProductsPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class LoginTest extends WebBaseTest {

  @Test(priority = 1, dataProvider = "valid-login", dataProviderClass = DataTestProvider.class)
  public void validLoginTest(String username, String password) {
    LoginPage loginPage = new LoginPage();
    loginPage.login(username, password);
    ProductsPage productsPage = new ProductsPage();
    log.info("this message should be displayed");
    Assert.assertEquals(productsPage.getTitle().getText(), PRODUCT_PAGE_TITLE.getName(),
      "Login fail the Products page is not displayed");
  }

  @Test(priority = 2, dataProvider = "locked-login", dataProviderClass = DataTestProvider.class)
  public void lockedLoginTest(String username, String password) {
    LoginPage loginPage = new LoginPage();
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.isLoginFailed());
  }
}
