package com.automationfw.hooks;

import static com.automationfw.data.Constants.CHECKOUT_INFO_KEY;
import static com.automationfw.data.DataTestProvider.getDataCompletePurchase;
import static com.automationfw.data.Properties.SCREENSHOT_PATH;
import static com.automationfw.driver.DriverManager.createWebDriver;
import static com.automationfw.utils.TestContextManager.getTestContext;

import com.automationfw.data.Properties;
import com.automationfw.driver.DriverManager;
import com.automationfw.listeners.TestListeners;
import com.automationfw.utils.PropertiesManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
      byte[] screenshot = takeScreenshot();
      attachScreenshot(screenshot);
    }
    DriverManager.closeDriver();
  }

  private byte[] takeScreenshot() {
    TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);
    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    File destination = new File(SCREENSHOT_PATH + "/screenshot-" + timeStamp + ".png");

    try {
      Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
      return Files.readAllBytes(destination.toPath());
    } catch (IOException e) {
      log.error("IOException while taking screenshot: {}", e.getMessage());
      return new byte[0];
    }
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] attachScreenshot(byte[] screenshot) {
    return screenshot;
  }

//  @Step("After Method")
//  @AfterStep
//  public void afterStep(Scenario scenario){
//    if (scenario.isFailed()){
//      log.info("SCENARIO FAIL FROM AFTER STEP");
//      byte[] screenshot = takeScreenshot();
//      attachScreenshot(screenshot);
//    }
//  }

}
