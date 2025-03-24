package com.automationfw.api.tasks;

import static com.automationfw.data.Constants.POKEMON_GET_RESPONSE_KEY;
import static com.automationfw.data.DataTestProvider.getDataPokemons;
import static com.automationfw.utils.TestContextManager.getTestContext;

import com.automationfw.api.requests.PokemonResquest;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class PokemonResquestTask extends PokemonResquest {

  @Step("GET request pokemon name")
  public void getRequestPokemonName(String type) {
    getTestContext().set(POKEMON_GET_RESPONSE_KEY.getName(),
      getPokemonByName(getDataPokemons(type).getName()));
  }
}
