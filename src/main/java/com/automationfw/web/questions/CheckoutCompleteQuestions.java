package com.automationfw.web.questions;

import com.automationfw.web.pages.CheckoutCompletePage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CheckoutCompleteQuestions extends CheckoutCompletePage {

  @Step("Is the checkout complete page displayed")
  public void isCheckoutcompletePageDisplayed() {
    waitForElementVisibility(getLblCompleteHeading());
    Assert.assertTrue(getLblCompleteHeading().isDisplayed());
  }
}
