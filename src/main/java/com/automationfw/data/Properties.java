package com.automationfw.data;

import com.automationfw.utils.PropertiesManager;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Properties {
  // web
  public static final String BASE_WEB_URL = PropertiesManager.getPropertyValue("base.url");
  public static final int TEST_TIMEOUT =
    Integer.parseInt(PropertiesManager.getPropertyValue("timeout"));
  public static final String BROWSER = PropertiesManager.getPropertyValue("browser");
  public static final String CREDENTIALS_PATH =
    PropertiesManager.getPropertyValue("credential.path");
  public static final String CHECKOUT_PERSONAL_INFORMATION_PATH =
    PropertiesManager.getPropertyValue("checkout.personalinfo.path");

  // api
  public static final String POKEMONS_DATA_PATH =
    PropertiesManager.getPropertyValue("pokemons.path");
  public static final String BASE_API_URI =
    PropertiesManager.getPropertyValue("base.api.uri");
  public static final String VALUE_CONTENT_TYPE =
    PropertiesManager.getPropertyValue("value.content.type");
  public static final String CONTENT_TYPE =
    PropertiesManager.getPropertyValue("content.type");

  // fw config
  public static final String SCREENSHOT_PATH =
    PropertiesManager.getPropertyValue("screenshots.path");
  public static final String ALLURE_REPORT_PATH =
    PropertiesManager.getPropertyValue("allure.report.path");
}
