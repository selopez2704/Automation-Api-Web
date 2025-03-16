package com.automationfw.data;

import lombok.Getter;

@Getter
public enum Constants {
  //  Web
  PRODUCT_PAGE_TITLE("Products"), CART_PAGE_TITLE("Your Cart"),
  CHECKOUT_YOUR_INFORMATION_PAGE_TITLE("Checkout: Your Information"),
  CHECKOUT_OVERVIEW("Checkout: Overview"), CHECKOUT_COMPLETE("Checkout: Complete!"),

  //  API
//  TODO: get from properties
  BASE_URI("https://pokeapi.co/api/v2/"),
  VALUE_CONTENT_TYPE("application/json"),
  CONTENT_TYPE("Content-Type");

  private final String name;

  Constants(String name) {
    this.name = name;
  }
}
