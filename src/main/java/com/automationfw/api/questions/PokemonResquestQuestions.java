package com.automationfw.api.questions;

import com.automationfw.api.requests.PokemonResquest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

public class PokemonResquestQuestions extends PokemonResquest {

  @Step("Validate Pokemon Request Status Code")
  public void validatePokemonStatusCode(Response res, int expectedStatusCode){
    Assert.assertEquals(res.getStatusCode() , expectedStatusCode, "GET request error Status code should be " + expectedStatusCode + ", but it's not");
  }
}
