package com.automationfw.web.stepsdefinitions;

import com.automationfw.web.questions.ProductsQuestions;
import com.automationfw.web.tasks.ProductsTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ProductsStepsDefinitions {
  private final ProductsTasks productsTasks = new ProductsTasks();
  private final ProductsQuestions productsQuestions = new ProductsQuestions();

  @Then("I should be able to see the products page")
  public void productPageShouldBeDisplayed() {
    productsTasks.waitForElementVisibility(productsTasks.getTitle());
    productsQuestions.isProductPageDisplayed();
  }

  @And("I sort the products from low to high price")
  public void sortProductsFromLowToHighPrice() {
    String cheapestProductName = productsTasks.getCheapestProductName();
    productsTasks.sortProductsLower2HighPrice();
    productsQuestions.valiteFirstProductLowestPrice(cheapestProductName);
  }

  @And("I add the first product listed to the cart")
  public void addFirstProductToCart() {
    productsTasks.addFirstProductToCart();
  }

  @And("I go to the cart")
  public void goToCartFromProducts() {
    productsTasks.goToCart();
  }
}
