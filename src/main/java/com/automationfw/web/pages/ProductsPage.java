package com.automationfw.web.pages;

import com.automationfw.web.pages.components.SortProductComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsPage extends WebBasePage {

  @FindBy(className = "title")
  private WebElement title;

  @FindBy(className = "inventory_item_name")
  private List<WebElement> lblItemNames;

  @FindBy(className = "inventory_item_price")
  private List<WebElement> lblItemPrices;

  @FindBy(xpath = "//*[contains(@id, 'add-to-cart-sauce-labs-')]")
  private List<WebElement> btnItemAddToCart;

  private SortProductComponent ddlSortProductElement;
}

