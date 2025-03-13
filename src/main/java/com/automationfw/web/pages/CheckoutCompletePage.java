package com.automationfw.web.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutCompletePage extends WebBasePage {

  @FindBy(className = "complete-header")
  WebElement lblCompleteHeading;

  public Boolean isCompleteHeadingDisplayed(){
    waitForElementVisibility(lblCompleteHeading);
    return lblCompleteHeading.isDisplayed();
  }
}
