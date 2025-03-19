package com.automationfw.listeners;

import com.automationfw.driver.DriverManager;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Slf4j
public class ScreenshotErrorManager implements ITestListener {

  @Override
  public void onTestFailure(ITestResult result) {
    byte[] screenshotByte = takeScreenshot(result.getName());
    Allure.addAttachment("Screenshot", "image/png",
      new ByteArrayInputStream(screenshotByte), "png");
  }

  private byte[] takeScreenshot(String testName) {
    TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);
    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//    TODO: property for path
    File destination = new File("src/test/screenshots/screenshot-" + testName + timeStamp+ ".png");

    try {
      Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
      return Files.readAllBytes(destination.toPath());
    } catch (IOException e) {
      log.error("IOException while taking screenshot: {}", e.getMessage());
      return new byte[0];
    }
  }
}
