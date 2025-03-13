package com.automationfw.tests.web;

import com.automationfw.data.DataTestProvider;
import com.automationfw.tests.BaseTest;
import com.automationfw.web.pages.LoginPage;
import com.automationfw.web.pages.ProductsPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PurchaseTest extends BaseTest {


  @Test(dataProvider = "valid-login", dataProviderClass = DataTestProvider.class)
  public void purchaseCheapestProductUsingInventoryFilters(String username, String password) {
    LoginPage loginPage = new LoginPage();
    loginPage.login(username, password);
    ProductsPage productsPage = new ProductsPage();
    Assert.assertEquals(productsPage.getTitle().getText(),"Products", "Login fail the Products page is not displayed");

  }
}
