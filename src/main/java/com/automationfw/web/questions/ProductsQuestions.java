package com.automationfw.web.questions;

import com.automationfw.web.pages.ProductsPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class ProductsQuestions extends ProductsPage {

  @Step("Is the Product Page Displayed")
  public void isProductPageDisplayed() {
    Assert.assertTrue(getTitle().isDisplayed());
  }

  @Step("Validate if the first product listed is the cheapest product")
  public void valiteFirstProductLowestPrice(String cheapestProductName) {
    Assert.assertEquals(cheapestProductName, getLblItemNames().get(0).getText());
  }
}
