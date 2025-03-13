package com.automationfw.web.pages.components;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginErrorBanner extends WebBaseComponent {

  @FindBy(className = "error-message-container error")
  private WebElement errorMessage;
}
