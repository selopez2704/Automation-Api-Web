package com.automationfw.listeners;

import static com.automationfw.data.Properties.SCREENSHOT_PATH;

import com.automationfw.driver.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.testng.ITestResult;

@Slf4j
public class TestListeners implements ITestListener, IExecutionListener {

  @Override
  public void onExecutionStart() {
    try {
      FileUtils.cleanDirectory(new File("allure-results"));
    } catch (IOException e) {
//      TODO: implement custom exceptions
      log.error("Error cleaning the allure directory: {}", e.getMessage());
    }
  }

  @Override
  public void onTestFailure(ITestResult result) {
    byte[] screenshotByte = takeScreenshot(result.getName());
    attachScreenshot(screenshotByte);
    Allure.addAttachment("Screenshot", "image/png",
      new ByteArrayInputStream(screenshotByte), "png");
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] attachScreenshot(byte[] screenshot) {
    return screenshot;
  }

  private byte[] takeScreenshot(String testName) {
    TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);
    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    File destination = new File(SCREENSHOT_PATH + "/screenshot-" + testName + timeStamp + ".png");

    try {
      Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
      return Files.readAllBytes(destination.toPath());
    } catch (IOException e) {
      log.error("IOException while taking screenshot: {}", e.getMessage());
      return new byte[0];
    }
  }
}
