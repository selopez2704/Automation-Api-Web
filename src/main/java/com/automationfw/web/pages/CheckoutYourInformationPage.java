package com.automationfw.web.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutYourInformationPage extends WebBasePage {

  @FindBy(id = "first-name")
  private WebElement txtFirstName;

  @FindBy(id = "last-name")
  private WebElement txtLastName;

  @FindBy(id = "postal-code")
  private WebElement txtPostalCode;

  @FindBy(id = "continue")
  private WebElement btnContinue;
}
