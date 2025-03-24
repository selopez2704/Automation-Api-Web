package com.automationfw.api.requests;

import io.restassured.response.Response;

public class PokemonResquest extends BaseRequest {

  public Response getPokemonByName(String name) {
    return requestGet("pokemon", createBaseHeaders(), name);
  }
}
