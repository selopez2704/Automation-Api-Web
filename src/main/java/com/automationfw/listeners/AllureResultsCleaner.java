package com.automationfw.listeners;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.testng.IExecutionListener;
import java.io.File;
import org.apache.commons.io.FileUtils;

@Slf4j
public class AllureResultsCleaner implements IExecutionListener {
  @Override
  public void onExecutionStart() {
    try {
      FileUtils.cleanDirectory(new File("allure-results"));
    } catch (IOException e) {
//      TODO: implement custom exceptions
      log.error("Error cleaning the allure directory: {}", e.getMessage());
    }
  }
}