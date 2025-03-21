package com.automationfw.data;

import com.automationfw.utils.PropertiesManager;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Properties {
  public static final String BASE_WEB_URL = PropertiesManager.getPropertyValue("base.url");
  public static final int TEST_TIMEOUT =
    Integer.parseInt(PropertiesManager.getPropertyValue("timeout"));
  public static final String BROWSER = PropertiesManager.getPropertyValue("browser");
  public static final String CREDENTIALS_PATH =
    PropertiesManager.getPropertyValue("credential.path");
  public static final String CHECKOUT_PERSONAL_INFORMATION_PATH =
    PropertiesManager.getPropertyValue("checkout.personalinfo.path");
  public static final String SCREENSHOT_PATH =
    PropertiesManager.getPropertyValue("screenshots.path");
  public static final String ALLURE_REPORT_PATH =
    PropertiesManager.getPropertyValue("allure.report.path");
}
