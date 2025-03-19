package com.automationfw.tests.api;

import com.automationfw.utils.PropertiesManager;
import org.testng.annotations.BeforeSuite;

public class ApiBaseTest {

  @BeforeSuite
  public void suiteSetup(){
    PropertiesManager.getInstance("properties/common.properties");
  }

}
