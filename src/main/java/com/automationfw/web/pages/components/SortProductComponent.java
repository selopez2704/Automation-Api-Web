package com.automationfw.web.pages.components;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SortProductComponent extends WebBaseComponent{

  @FindBy(className = "product-sort-container")
  private WebElement ddlSortProductElement;
  Select ddlSortProductSelect = new Select(ddlSortProductElement);

  private void clickByLowPrice() {
      ddlSortProductSelect.selectByContainsVisibleText("Price (low to high)");
  }
}
