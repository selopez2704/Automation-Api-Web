package com.automationfw.tests.web;

import static com.automationfw.driver.DriverManager.closeDriver;
import static com.automationfw.driver.DriverManager.createWebDriver;


import com.automationfw.driver.DriverManager;
import com.automationfw.data.Properties;
import com.automationfw.utils.PropertiesManager;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class WebBaseTest {

  @BeforeSuite
  public void suiteSetup() {
    PropertiesManager.getInstance("properties/common.properties");
  }

  @BeforeMethod
  public void testSetup() {
    createWebDriver(Properties.BROWSER);
    DriverManager.getDriver()
      .manage()
      .timeouts()
      .implicitlyWait(Duration.ofSeconds(Properties.TEST_TIMEOUT));
    DriverManager.openPage(Properties.BASE_WEB_URL);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    closeDriver();
  }
}
