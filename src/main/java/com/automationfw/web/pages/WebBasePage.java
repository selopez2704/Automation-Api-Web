package com.automationfw.web.pages;

import com.automationfw.driver.DriverManager;
import com.automationfw.driver.Properties;
import java.time.Duration;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
@Getter
public class WebBasePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  @FindBy(className = "title")
  private WebElement title;

  @FindBy(className = "shopping_cart_link")
  private WebElement btnCart;

  public WebBasePage() {
    this.driver = DriverManager.getDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(Properties.TEST_TIMEOUT));
    PageFactory.initElements(driver, this);
  }

  public void clickOnElement(WebElement element) {
    waitForElementVisibility(element);
    try {
      element.click();
    } catch (StaleElementReferenceException e) {
      PageFactory.initElements(driver, this);
      element.click();
    }
  }

  public void sendKeysToElement(WebElement element, String key) {
    waitForElementVisibility(element);
    try {
      element.sendKeys(key);
    } catch (StaleElementReferenceException e) {
      log.error("Stale Element Error");
    }
  }

  public void waitForElementVisibility(WebElement element) {
    try {
      wait.until(d -> element.isDisplayed());
    } catch (TimeoutException e) {
      log.error("Element not visible {}", element.getText());
    } catch (Exception e) {
      log.error("Unexpected error while waiting for element visibility: {}", e.getMessage());
    }
  }

  public void goToCart() {
    clickOnElement(getBtnCart());
  }
}

