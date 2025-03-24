package com.automationfw.web.stepsdefinitions;

import static com.automationfw.data.Constants.LOGIN_CREDENTIALS_KEY;
import static com.automationfw.data.DataTestProvider.getDataLogIn;
import static com.automationfw.utils.TestContextManager.getTestContext;

import com.automationfw.data.Credential;
import com.automationfw.web.questions.LoginQuestions;
import com.automationfw.web.tasks.LoginTasks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginStepsDefinitions {
  private final LoginTasks loginTasks = new LoginTasks();
  private final LoginQuestions loginQuestions = new LoginQuestions();

  @Given("I Login with (.*) credentials$")
  public void performLogin(String credentialType) {
    log.info("Ejecutando test step en hilo: " + Thread.currentThread().getId());
    getTestContext().set(LOGIN_CREDENTIALS_KEY.getName(), getDataLogIn(credentialType));
    Credential loginCredentials =
      (Credential) (getTestContext().get(LOGIN_CREDENTIALS_KEY.getName()));
    loginTasks.login(loginCredentials.getUsername(), loginCredentials.getPassword());
  }

  @Then("The login should fails")
  public void loginShouldFails() {
    loginQuestions.validateLoginShouldFails();
  }
}
