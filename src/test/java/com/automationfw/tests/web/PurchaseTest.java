package com.automationfw.tests.web;

import static com.automationfw.data.Constants.CHECKOUT_COMPLETE;
import static com.automationfw.data.Constants.CHECKOUT_OVERVIEW;
import static com.automationfw.data.Constants.CHECKOUT_YOUR_INFORMATION_PAGE_TITLE;
import static com.automationfw.data.Constants.PRODUCT_PAGE_TITLE;
import static com.automationfw.data.Constants.CART_PAGE_TITLE;

import com.automationfw.data.DataTestProvider;
import com.automationfw.tests.BaseTest;
import com.automationfw.web.pages.CartPage;
import com.automationfw.web.pages.CheckoutCompletePage;
import com.automationfw.web.pages.CheckoutOverviewPage;
import com.automationfw.web.pages.CheckoutYourInformationPage;
import com.automationfw.web.pages.LoginPage;
import com.automationfw.web.pages.ProductsPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PurchaseTest extends BaseTest {


  @Test(dataProvider = "complete-purchase", dataProviderClass = DataTestProvider.class)
  public void purchaseCheapestProductUsingInventoryFilters(String username, String password,
                                                           String firstName, String lastName,
                                                           String postalCode) {

    //Login
    LoginPage loginPage = new LoginPage();
    loginPage.login(username, password);
    ProductsPage productsPage = new ProductsPage();
    Assert.assertEquals(productsPage.getTitle().getText(), PRODUCT_PAGE_TITLE.getName(),
      "Login fail the Products page is not displayed");

    //Sort Products
    String cheapestProductName = productsPage.getCheapestProductName();
    productsPage.sortProductsLower2HighPrice();
    Assert.assertEquals(cheapestProductName, productsPage.getLblItemNames().get(0).getText());

    //Add To Cart
    productsPage.addFirstProductToCart();
    productsPage.goToCart();
    CartPage cartPage = new CartPage();
    Assert.assertEquals(cartPage.getTitle().getText(), CART_PAGE_TITLE.getName());
    cartPage.goToCheckoutYourInformation();

    // Checkout Your information
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
    Assert.assertEquals(checkoutYourInformationPage.getTitle().getText(),
      CHECKOUT_YOUR_INFORMATION_PAGE_TITLE.getName());
    checkoutYourInformationPage.fillYourInfoForm(firstName, lastName, postalCode);
    checkoutYourInformationPage.goToCheckOverview();

    // Checkout Checkout
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    Assert.assertEquals(checkoutOverviewPage.getTitle().getText(), CHECKOUT_OVERVIEW.getName());
    checkoutOverviewPage.goToCheckoutComplete();

    // Checkout Finish
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
    Assert.assertEquals(checkoutCompletePage.getTitle().getText(), CHECKOUT_COMPLETE.getName());
    Assert.assertTrue(checkoutCompletePage.isCompleteHeadingDisplayed());
  }
}
