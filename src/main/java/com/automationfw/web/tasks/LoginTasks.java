package com.automationfw.web.tasks;

import com.automationfw.web.pages.LoginPage;
import io.qameta.allure.Step;

public class LoginTasks extends LoginPage {

  @Step("Login to the website")
  public void login(String user, String password) {
    sendKeysToElement(getTxtUserName(), user);
    sendKeysToElement(getTxtPassword(), password);
    clickOnElement(getBtnLogin());
  }

  public Boolean isLoginFailed() {
    waitForElementVisibility(getErrorMessage());
    return getErrorMessage().isDisplayed();
  }
}
