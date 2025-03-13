package com.automationfw.web.pages.components;

import static com.automationfw.driver.DriverManager.getDriver;

import com.automationfw.web.pages.WebBasePage;
import org.openqa.selenium.support.PageFactory;

public class WebBaseComponent extends WebBasePage {

  protected WebBaseComponent() {
    super();
    PageFactory.initElements(getDriver(), this);
  }
}
