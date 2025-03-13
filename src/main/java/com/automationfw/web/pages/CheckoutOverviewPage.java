package com.automationfw.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends WebBasePage {

  @FindBy(id = "finish")
  WebElement btnFinish;

  public void goToCheckoutComplete(){
    clickOnElement(btnFinish);
  }
}
