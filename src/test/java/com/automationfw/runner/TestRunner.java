package com.automationfw.runner;

import com.automationfw.listeners.TestListeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
  features = "src/test/resources/features",
  glue = "com.automationfw",
  plugin = {"pretty",
    "html:target/cucumber-reports.html",
    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Listeners(TestListeners.class)
public class TestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
