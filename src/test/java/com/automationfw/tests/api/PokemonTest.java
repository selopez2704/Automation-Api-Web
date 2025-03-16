package com.automationfw.tests.api;

import com.automationfw.api.requests.PokemonResquest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PokemonTest {

  @Test
  public void getPokemonSuccessTest() {
    PokemonResquest pokemonResquest = new PokemonResquest();
    Assert.assertEquals(pokemonResquest.getPokemonByName("pikachu").getStatusCode(), 200,
      "GET resquest error Status code should be 200, but it's not");
    log.info("GET success");
  }

  @Test
  public void getPokemonBadResquestTest() {
    PokemonResquest pokemonResquest = new PokemonResquest();
    Assert.assertEquals(pokemonResquest.getPokemonByName("not-exist").getStatusCode(), 404,
      "GET resquest error Status code should be 404, but it's not");
    log.info("GET bad request test success");
  }
}
