package com.automationfw.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends WebBasePage {

  @FindBy(id = "finish")
  WebElement btnFinish;

  @Step("Go to checkout complete")
  public void goToCheckoutComplete(){
    clickOnElement(btnFinish);
  }
}
