package com.automationfw.web.questions;

import com.automationfw.web.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class LoginQuestions extends LoginPage {

  @Step("login error message validation")
  public void validateLoginShouldFails() {
    Assert.assertTrue(getErrorMessage().isDisplayed());
  }
}
