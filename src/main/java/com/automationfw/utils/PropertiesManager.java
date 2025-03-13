package com.automationfw.utils;


import lombok.experimental.UtilityClass;

@UtilityClass
public class PropertiesManager {

  public static String getPropertyFromEnv(String key) {
    return System.getenv(formatAsEnvVar(key));
  }

  private static String formatAsEnvVar(String str) {
    return str.toUpperCase().replace(".", "-");
  }
}
