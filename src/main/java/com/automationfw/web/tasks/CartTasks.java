package com.automationfw.web.tasks;

import com.automationfw.web.pages.CartPage;
import io.qameta.allure.Step;

public class CartTasks extends CartPage {

  @Step("Go to checkout personal information")
  public void goToCheckoutYourInformation() {
    clickOnElement(getBtnCheckout());
  }
}
