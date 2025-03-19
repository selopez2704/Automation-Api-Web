package com.automationfw.tests.api;

import com.automationfw.api.requests.PokemonResquest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PokemonApiTest extends ApiBaseTest{

  @Test
  public void getPokemonSuccessTest() {
    PokemonResquest pokemonResquest = new PokemonResquest();
    Response response = pokemonResquest.getPokemonByName("pikachu");
    Assert.assertEquals(response.getStatusCode(), 200,
      "GET resquest error Status code should be 200, but it's not");
    log.info("GET success");
    logResponse(response);
  }

  @Test
  public void getPokemonBadResquestTest() {
    PokemonResquest pokemonResquest = new PokemonResquest();
    Assert.assertEquals(pokemonResquest.getPokemonByName("not-exist").getStatusCode(), 404,
      "GET resquest error Status code should be 404, but it's not");
    log.info("GET bad request test success");
//    logResponse();
  }

  @Step("Log response")
  public void logResponse(Response response) {
    Allure.addAttachment("Response", "application/json", response.asInputStream(), "json");
  }
}
