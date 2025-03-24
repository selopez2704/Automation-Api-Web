package com.automationfw.web.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
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

  @FindBy(className = "error-message-container")
  private WebElement errorMessage;
}
