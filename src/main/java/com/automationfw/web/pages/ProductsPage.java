package com.automationfw.web.pages;

import com.automationfw.web.pages.components.SortProductComponent;
import io.qameta.allure.Step;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsPage extends WebBasePage {

  @FindBy(className = "inventory_item_name")
  private List<WebElement> lblItemNames;

  @FindBy(className = "inventory_item_price")
  private List<WebElement> lblItemPrices;

  @FindBy(xpath = "//*[contains(@id, 'add-to-cart-sauce-labs-')]")
  private List<WebElement> btnItemAddToCart;

  private final SortProductComponent ddlSortProduct = new SortProductComponent();

  public void displaySortDropdown() {
    clickOnElement(ddlSortProduct.getDdlSortProductElement());
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
      .collect(Collectors.toList());
    Optional<Double> minValueOptional = listPrices.stream().min(Double::compareTo);
    int index = listPrices.indexOf(minValueOptional.get());
    return getLblItemNames().get(index).getText();
  }

  @Step("Add first product to cart")
  public void addFirstProductToCart() {
    clickOnElement(getBtnItemAddToCart().get(0));
  }
}

