package com.automationfw.driver;

import static com.automationfw.data.Properties.SELENIUM_HUB_URL;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import lombok.Getter;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
@UtilityClass
@Getter
public class DriverManager {
  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  //  TODO: refactor to user yield
  public static void createWebDriver(String browser) {
    try {

      switch (browser.toLowerCase()) {
        case "chrome":
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--incognito");
          chromeOptions.addArguments("--start-maximized");
          chromeOptions.addArguments("--disable-infobars");
          chromeOptions.addArguments("--no-sandbox");
          driverThreadLocal.set(new RemoteWebDriver(new URL(SELENIUM_HUB_URL), chromeOptions));
//        driverThreadLocal.set(new ChromeDriver(chromeOptions));
          break;
        case "firefox":
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          firefoxOptions.addArguments("--incognito");
          firefoxOptions.addArguments("--start-maximized");
          firefoxOptions.addArguments("--disable-infobars");
          firefoxOptions.addArguments("--no-sandbox");
          String url = SELENIUM_HUB_URL;
          URL url1 = new URL(url);
          RemoteWebDriver driver = new RemoteWebDriver(new URL(url), firefoxOptions);
          driverThreadLocal.set(new RemoteWebDriver(new URL(url), firefoxOptions));
          break;
        case "edge":
          EdgeOptions edgeOptions = new EdgeOptions();
          edgeOptions.addArguments("--incognito");
          edgeOptions.addArguments("--start-maximized");
          edgeOptions.addArguments("--disable-infobars");
          edgeOptions.addArguments("--no-sandbox");
          driverThreadLocal.set(new RemoteWebDriver(new URL(SELENIUM_HUB_URL), edgeOptions));
          break;
        default:
          throw new IllegalArgumentException("Browser not supported: " + browser);
      }
    }
    catch (MalformedURLException e){
      log.error("Error  while connecting with Selenium hub: {}", e.getMessage());
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
