package com.automationfw.api.stepsdefinitions;

import static com.automationfw.data.Constants.POKEMON_GET_RESPONSE_KEY;
import static com.automationfw.utils.TestContextManager.getTestContext;

import com.automationfw.api.questions.PokemonResquestQuestions;
import com.automationfw.api.tasks.PokemonResquestTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class PokemonStepsDefinitions {
  private final PokemonResquestTask pokemonResquestTask = new PokemonResquestTask();
  private final PokemonResquestQuestions pokemonResquestQuestions = new PokemonResquestQuestions();

  @Given("I send a (.*) GET request for a pokemon name$")
  public void getRequestPokemonName(String requestGetType) {
    pokemonResquestTask.getRequestPokemonName(requestGetType);
  }

  @Then("The response code should be (.*)$")
  public void validateCodeResponse(String strExpectedCode) {
    int expectedCode = Integer.parseInt(strExpectedCode);
    Response response = (Response)getTestContext().get(POKEMON_GET_RESPONSE_KEY.getName());
    pokemonResquestQuestions.validatePokemonStatusCode(response, expectedCode);
  }
}
