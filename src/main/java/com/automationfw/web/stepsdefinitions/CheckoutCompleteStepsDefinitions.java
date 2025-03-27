package com.automationfw.web.stepsdefinitions;

import com.automationfw.web.questions.CheckoutCompleteQuestions;
import io.cucumber.java.en.Then;

public class CheckoutCompleteStepsDefinitions {
  private final CheckoutCompleteQuestions checkoutCompleteQuestions =
    new CheckoutCompleteQuestions();

  @Then("The checkout complete page should be correctly displayed")
  public void isCheckoutcompletePageDisplayed() {
    checkoutCompleteQuestions.isCheckoutcompletePageDisplayed();
  }
}
