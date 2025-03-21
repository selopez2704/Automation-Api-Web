package com.automationfw.data;


import static com.automationfw.data.Properties.CHECKOUT_PERSONAL_INFORMATION_PATH;
import static com.automationfw.data.Properties.CREDENTIALS_PATH;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
@Getter
public class CustomJsonReader {

  public static Credential getJsonCredential(String type) throws IOException {
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

  public static PersonalInformation getJsonPersonalInformation() throws IOException {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File credentialJsonFile =
        new File(CHECKOUT_PERSONAL_INFORMATION_PATH);
      List<PersonalInformation> personalInformations = objectMapper.readValue(credentialJsonFile,
        new TypeReference<List<PersonalInformation>>() {
        });
      return personalInformations.get(0);
    } catch (java.io.IOException e) {
      log.error("Error while reading the checkout personal information file: {}", e.getMessage());
    }
    return null;
  }
}
