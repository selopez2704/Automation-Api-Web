package com.automationfw.data;

import lombok.Getter;

@Getter
public enum Constants {
  PRODUCT_PAGE_TITLE("Products"),
  CART_PAGE_TITLE("Your Cart"),
  CHECKOUT_YOUR_INFORMATION_PAGE_TITLE("Checkout: Your Information"),
  CHECKOUT_OVERVIEW("Checkout: Overview"),
  CHECKOUT_COMPLETE("Checkout: Complete!");

  private final String name;

  Constants(String name) {
    this.name = name;
  }
}
