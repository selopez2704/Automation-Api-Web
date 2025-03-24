package com.automationfw.web.tasks;

import com.automationfw.web.pages.CheckoutOverviewPage;
import io.qameta.allure.Step;

public class CheckoutOverviewTasks extends CheckoutOverviewPage {

  @Step("Go to checkout complete")
  public void goToCheckoutComplete() {
    clickOnElement(getBtnFinish());
  }
}
