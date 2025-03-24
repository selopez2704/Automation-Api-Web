package com.automationfw.web.stepsdefinitions;

import com.automationfw.web.tasks.CheckoutOverviewTasks;
import io.cucumber.java.en.And;

public class CheckoutOverviewStepsDefinitions {
  CheckoutOverviewTasks checkoutOverviewTasks = new CheckoutOverviewTasks();

  @And("I go to checkout complete")
  public void goToCheckoutComplete() {
    checkoutOverviewTasks.goToCheckoutComplete();
  }
}
