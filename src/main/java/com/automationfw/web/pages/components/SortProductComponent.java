package com.automationfw.web.pages.components;


import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class SortProductComponent extends WebBaseComponent {

  @FindBy(className = "select_container")
  private WebElement ddlSortProductElement;
//  Select ddlSortProductSelect = new Select(ddlSortProductElement);

  @FindBy(xpath = "//option[contains(text(), 'Price (low to high)')]\n")
  private WebElement ddlOptLowerPrice;

  public void sortByLowPrice() {
//    ddlSortProductSelect.selectByContainsVisibleText("Price (low to high)");
    clickOnElement(ddlOptLowerPrice);
  }
}
