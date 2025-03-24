package com.automationfw.api.requests;

import static com.automationfw.data.Properties.BASE_API_URI;
import static com.automationfw.data.Properties.CONTENT_TYPE;
import static com.automationfw.data.Properties.VALUE_CONTENT_TYPE;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseRequest {

  public BaseRequest() {
    RestAssured.baseURI = BASE_API_URI;
  }

  protected Map<String, String> createBaseHeaders() {
    Map<String, String> headers = new HashMap<>();
    headers.put(CONTENT_TYPE, VALUE_CONTENT_TYPE);
    return headers;
  }

  protected Response requestGet(String endpoint, Map<String, ?> headers, String pathParameter) {
    try {
      return RestAssured.given().filter(new AllureRestAssured())
        .contentType(VALUE_CONTENT_TYPE)
        .headers(headers)
        .when()
        .get(String.format("%s/%s", endpoint, pathParameter));
    } catch (Exception e) {
      log.error("error while GET request");
    }
    return null;
  }


}
