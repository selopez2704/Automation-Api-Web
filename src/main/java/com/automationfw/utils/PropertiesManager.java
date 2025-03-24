package com.automationfw.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesManager {
  private static PropertiesManager instance;
  private static final Properties properties = new Properties();

  public PropertiesManager(String filePath) {
    loadProperties(filePath);
  }

  public static synchronized PropertiesManager getInstance(String filePath) {
    if (instance == null) {
      instance = new PropertiesManager(filePath);
    }
    return instance;
  }

  private void loadProperties(String filePath) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      InputStream input = classLoader.getResourceAsStream(filePath);

      properties.load(input);
    } catch (IOException e) {
      log.error("Error loading environment properties");
    }
  }

  public static String getPropertyValue(String key) {
    String value = getPropertyFromEnv(key);
    if (value == null) {
      value = getConfigProperty(key);
    }
    return value;
  }

  public static String getProperty(String key) {
    return properties.getProperty(key.trim());
  }

  public static String getPropertyFromEnv(String key) {
    return System.getenv(formatAsEnvVar(key));
  }

  public static String getConfigProperty(String key) {
    return getProperty(key);
  }

  private static String formatAsEnvVar(String str) {
    return str.toUpperCase().replace(".", "-");
  }


}
