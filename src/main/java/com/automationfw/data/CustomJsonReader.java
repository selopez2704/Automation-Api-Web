package com.automationfw.data;


import static com.automationfw.data.Properties.CHECKOUT_PERSONAL_INFORMATION_PATH;
import static com.automationfw.data.Properties.CREDENTIALS_PATH;
import static com.automationfw.data.Properties.POKEMONS_DATA_PATH;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
@Getter
public class CustomJsonReader {

  public static Credential getJsonCredential(String type) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File credentialJsonFile =
        new File(CREDENTIALS_PATH);
      List<Credential> credentials = objectMapper.readValue(credentialJsonFile,
        new TypeReference<List<Credential>>() {
        });
      return credentials.stream()
        .filter(credential -> credential.getType().equals(type))
        .findFirst()
        .orElse(null);
    } catch (java.io.IOException e) {
      log.error("Error while reading the credential file: {}", e.getMessage());
    }
    return null;
  }

  public static PersonalInformation getJsonPersonalInformation() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File credentialJsonFile =
        new File(CHECKOUT_PERSONAL_INFORMATION_PATH);
      List<PersonalInformation> personalInformation = objectMapper.readValue(credentialJsonFile,
        new TypeReference<List<PersonalInformation>>() {
        });
      return personalInformation.get(0);
    } catch (java.io.IOException e) {
//      TODO: crate a custom exception
      log.error("Error while reading the checkout personal information file: {}", e.getMessage());
    }
    return null;
  }

  public static List<Pokemon> getJsonPokemons() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File pokemonJsonFile =
        new File(POKEMONS_DATA_PATH);
      return objectMapper.readValue(pokemonJsonFile,
        new TypeReference<List<Pokemon>>() {
        });
    } catch (java.io.IOException e) {
//      TODO: crate a custom exception
      log.error("Error while reading the pokemon file: {}", e.getMessage());
    }
    return null;
  }
}
