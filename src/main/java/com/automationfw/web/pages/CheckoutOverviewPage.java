package com.automationfw.web.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutOverviewPage extends WebBasePage {

  @FindBy(id = "finish")
  private WebElement btnFinish;

}
