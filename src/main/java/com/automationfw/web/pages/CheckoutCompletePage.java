package com.automationfw.web.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutCompletePage extends WebBasePage {

  @FindBy(className = "complete-header")
  WebElement lblCompleteHeading;

  @Step("Validate if the complete Heading is displayed")
  public Boolean isCompleteHeadingDisplayed(){
    waitForElementVisibility(lblCompleteHeading);
    return lblCompleteHeading.isDisplayed();
  }
}
