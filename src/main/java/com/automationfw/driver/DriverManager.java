package com.automationfw.driver;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import lombok.Getter;
import org.openqa.selenium.firefox.FirefoxOptions;


@UtilityClass
@Getter
public class DriverManager {
  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  public static void createWebDriver(String browser) {
    switch (browser.toLowerCase()) {
      case "chrome":
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--no-sandbox");
        driverThreadLocal.set(new ChromeDriver(chromeOptions));
        break;
      case "firefox":
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--no-sandbox");
        driverThreadLocal.set(new FirefoxDriver());
        break;
      case "edge":
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--no-sandbox");
        driverThreadLocal.set(new EdgeDriver());
        break;
      default:
        throw new IllegalArgumentException("Browser not supported: " + browser);
    }
  }

  public static WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  public void openPage(String url) {
    getDriver().get(url);
  }

  public static void closeDriver() {
    getDriver().quit();
    driverThreadLocal.remove();
  }
}
