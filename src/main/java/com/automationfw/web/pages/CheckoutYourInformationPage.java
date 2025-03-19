package com.automationfw.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends WebBasePage {

  @FindBy(id = "first-name")
  WebElement txtFirstName;

  @FindBy(id = "last-name")
  WebElement txtLastName;

  @FindBy(id = "postal-code")
  WebElement txtPostalCode;

  @FindBy(id = "continue")
  WebElement btnContinue;

  @Step("Fill personal information form")
  public void fillYourInfoForm(String firstName, String LastName, String PostalCode){
    sendKeysToElement(txtFirstName,firstName);
    sendKeysToElement(txtLastName,LastName);
    sendKeysToElement(txtPostalCode,PostalCode);
  }

  @Step("Go to checkout overview")
  public void goToCheckOverview(){
    clickOnElement(btnContinue);
  }

}
