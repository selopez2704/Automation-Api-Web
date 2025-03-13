package com.automationfw.data;


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
public class CredentialJsonReader {

  public static Credential getJsonCredential(String type) throws IOException {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
//      TODO: create read property file
      File credentialJsonFile =
        new File("src/test/java/com/automationfw/resources/loginCredentials.json");
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
}
