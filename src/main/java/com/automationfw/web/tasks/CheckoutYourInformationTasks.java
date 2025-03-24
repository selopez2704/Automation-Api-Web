package com.automationfw.web.tasks;

import com.automationfw.web.pages.CheckoutYourInformationPage;
import io.qameta.allure.Step;

public class CheckoutYourInformationTasks extends CheckoutYourInformationPage {

  @Step("Fill personal information form")
  public void fillYourInfoForm(String firstName, String LastName, String PostalCode) {
    sendKeysToElement(getTxtFirstName(), firstName);
    sendKeysToElement(getTxtLastName(), LastName);
    sendKeysToElement(getTxtPostalCode(), PostalCode);
  }

  @Step("Go to checkout overview")
  public void goToCheckOverview() {
    clickOnElement(getBtnContinue());
  }
}
