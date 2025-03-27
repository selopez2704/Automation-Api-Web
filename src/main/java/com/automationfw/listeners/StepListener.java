package com.automationfw.listeners;

import static com.automationfw.data.Properties.SCREENSHOT_PATH;

import com.automationfw.driver.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Slf4j
public class StepListener implements StepLifecycleListener {

  @Override
  @SneakyThrows
  public void beforeStepStop(final StepResult result) {
    if (result.getStatus().value().equals("failed")
      || result.getStatus().value().equals("broken")) {
      byte[] screenshot = takeScreenshot();
      attachScreenshot(screenshot);
    }
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] attachScreenshot(byte[] screenshot) {
    return screenshot;
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
}

