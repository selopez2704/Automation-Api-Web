package com.automationfw.web.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends WebBasePage {

  @FindBy(id = "user-name")
  private WebElement txtUserName;

  @FindBy(id = "password")
  private WebElement txtPassword;

  @FindBy(id = "login-button")
  private WebElement btnLogin;

//  TODO: Create a Web Component
//  @FindBy(className = "error-message-container error")
//  private WebElement errorMessage;

  public void login(String user, String password) {
    sendKeysToElement(getTxtUserName(), user);
    sendKeysToElement(getTxtPassword(), password);
    clickOnElement(getBtnLogin());
  }

//  public Boolean isLoginFailed(){
//    waitForElementVisibility(errorMessage);
//    return errorMessage.isDisplayed();
//  }

}
