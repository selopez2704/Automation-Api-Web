package com.automationfw.web.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutCompletePage extends WebBasePage {

  @FindBy(className = "complete-header")
  private WebElement lblCompleteHeading;
}
