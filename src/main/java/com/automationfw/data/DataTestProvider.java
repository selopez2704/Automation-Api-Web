package com.automationfw.data;

import static com.automationfw.data.CustomJsonReader.getJsonCredential;
import static com.automationfw.data.CustomJsonReader.getJsonPersonalInformation;
import static com.automationfw.data.CustomJsonReader.getJsonPokemons;

import java.util.Objects;
import java.util.Optional;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class DataTestProvider {


  public static Credential getDataLogIn(String key) {
    return getJsonCredential(key + "Credentials");
  }

  public static PersonalInformation getDataCompletePurchase() {
    return getJsonPersonalInformation();
  }

  public static Pokemon getDataPokemons(String type) {
    Optional<Pokemon> pokemon = Objects.requireNonNull(getJsonPokemons()).stream()
      .filter(poke -> poke.getRequestType().equals(type))
      .findFirst();
    return pokemon.get();
  }
}
