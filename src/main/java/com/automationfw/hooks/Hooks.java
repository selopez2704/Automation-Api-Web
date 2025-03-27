package com.automationfw.hooks;

import static com.automationfw.data.Constants.CHECKOUT_INFO_KEY;
import static com.automationfw.data.DataTestProvider.getDataCompletePurchase;
import static com.automationfw.driver.DriverManager.createWebDriver;
import static com.automationfw.utils.TestContextManager.getTestContext;

import com.automationfw.data.Properties;
import com.automationfw.driver.DriverManager;
import com.automationfw.utils.PropertiesManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

  @Before(value = "@SouceDemo")
  public void setUpWeb() {
    PropertiesManager.getInstance("properties/common.properties");
    getTestContext().set(CHECKOUT_INFO_KEY.getName(), getDataCompletePurchase());
    createWebDriver(Properties.BROWSER);
    DriverManager.getDriver()
      .manage()
      .timeouts()
      .implicitlyWait(Duration.ofSeconds(Properties.TEST_TIMEOUT));
    DriverManager.openPage(Properties.BASE_WEB_URL);
  }

  @Before(value = "@Pokeapi")
  public void setUpApi() {
    PropertiesManager.getInstance("properties/common.properties");
  }

  @After(value = "@Pokeapi")
  public void tearDownApi(Scenario scenario) {
    log.info("Ending scenario: {}", scenario.getName());
  }

  @After(value = "@SouceDemo")
  public void tearDownWeb(Scenario scenario) {
    if (scenario.isFailed()) {
      log.error("scenario failed: {}", scenario.getName());
    }
    DriverManager.closeDriver();
  }
}
