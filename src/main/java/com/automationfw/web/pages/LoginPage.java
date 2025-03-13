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

  public void login(String user, String password){
    sendKeysToElement(txtUserName,user);
    sendKeysToElement(txtPassword,password);
    clickOnElement(btnLogin);
  }

}
