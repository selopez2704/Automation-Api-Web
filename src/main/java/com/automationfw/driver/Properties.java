package com.automationfw.driver;

import com.automationfw.utils.PropertiesManager;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Properties {
  public static final String BASE_WEB_URL = PropertiesManager.getPropertyFromEnv("base.url");
  public static final int TEST_TIMEOUT = Integer.parseInt(PropertiesManager.getPropertyFromEnv("timeout"));
  public static final String BROWSER = PropertiesManager.getPropertyFromEnv("browser");
}
