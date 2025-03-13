package com.automationfw.tests;

import static com.automationfw.driver.DriverManager.closeDriver;
import static com.automationfw.driver.DriverManager.createWebDriver;



import com.automationfw.driver.DriverManager;
import com.automationfw.driver.Properties;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  @BeforeMethod
  public void testSetup(){
    createWebDriver(Properties.BROWSER);
    DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Properties.TEST_TIMEOUT));
    DriverManager.openPage(Properties.BASE_WEB_URL);
  }

  @AfterMethod(alwaysRun = true)
  public void teardown(){
    closeDriver();
  }
}
