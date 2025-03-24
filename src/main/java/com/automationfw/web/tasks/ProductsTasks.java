package com.automationfw.web.tasks;

import com.automationfw.web.pages.ProductsPage;
import io.qameta.allure.Step;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductsTasks extends ProductsPage {

  public void displaySortDropdown() {
    clickOnElement(getDdlSortProduct().getDdlSortProductElement());
  }

  @Step("Sort products from lower to higher price")
  public void sortProductsLower2HighPrice() {
    displaySortDropdown();
    getDdlSortProduct().sortByLowPrice();
  }

  public String getCheapestProductName() {
    List<Double> listPrices = getLblItemPrices().stream()
      .map(element -> element.getText().replace("$", ""))
      .map(Double::parseDouble)
      .toList();
    Optional<Double> minValueOptional = listPrices.stream().min(Double::compareTo);
    int index = listPrices.indexOf(minValueOptional.get());
    return getLblItemNames().get(index).getText();
  }

  @Step("Add first product to cart")
  public void addFirstProductToCart() {
    clickOnElement(getBtnItemAddToCart().get(0));
  }

}

