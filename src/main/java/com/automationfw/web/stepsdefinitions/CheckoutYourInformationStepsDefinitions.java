package com.automationfw.web.stepsdefinitions;


import static com.automationfw.data.Constants.CHECKOUT_INFO_KEY;
import static com.automationfw.utils.TestContextManager.getTestContext;

import com.automationfw.data.PersonalInformation;
import com.automationfw.web.tasks.CheckoutYourInformationTasks;
import io.cucumber.java.en.And;

public class CheckoutYourInformationStepsDefinitions {
  private final CheckoutYourInformationTasks checkoutYourInformationTasks =
    new CheckoutYourInformationTasks();

  @And("I fill the Your Information form")
  public void fillYourInformationForm() {
    PersonalInformation personalInfo =
      (PersonalInformation) getTestContext().get(CHECKOUT_INFO_KEY.getName());
    checkoutYourInformationTasks.fillYourInfoForm(personalInfo.getFirstName(),
      personalInfo.getLastName(), personalInfo.getPostalCode());
  }

  @And("I go to checkout overview")
  public void goToCheckoutYourInformation() {
    checkoutYourInformationTasks.goToCheckOverview();
  }
}
