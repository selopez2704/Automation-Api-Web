package com.automationfw.web.pages;

import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartPage extends WebBasePage {

  @FindBy(className = "inventory_item_name")
  private List<WebElement> lblItemNames;

  @FindBy(id = "checkout")
  private WebElement btnCheckout;

  public void goToCheckoutYourInformation() {
    clickOnElement(btnCheckout);
  }

}
