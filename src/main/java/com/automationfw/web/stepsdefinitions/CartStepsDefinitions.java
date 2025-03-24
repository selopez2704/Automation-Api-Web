package com.automationfw.web.stepsdefinitions;

import com.automationfw.web.tasks.CartTasks;
import io.cucumber.java.en.And;

public class CartStepsDefinitions {
  private final CartTasks cartTasks = new CartTasks();

  @And("I go to checkout personal information")
  public void goToCheckoutYourInformation() {
    cartTasks.goToCheckoutYourInformation();
  }
}
