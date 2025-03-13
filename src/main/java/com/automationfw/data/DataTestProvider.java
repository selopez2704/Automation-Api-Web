package com.automationfw.data;

import static com.automationfw.data.CredentialJsonReader.getJsonCredential;

import java.io.IOException;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;

@Slf4j
@UtilityClass
public class DataTestProvider {

  @DataProvider(name = "valid-login")
  public static Object[][] testDataValidLogIn() throws IOException {
    Credential validCredentials = getJsonCredential("validCredentials");
    if (!Objects.isNull(validCredentials)) {
      return new Object[][] {
        {
          validCredentials.getUsername(), validCredentials.getPassword()
        }
      };
    } else {
      return new Object[0][0];
    }
  }

  @DataProvider(name = "locked-login")
  public static Object[][] testDataLockedLogIn() throws IOException {
    Credential validCredentials = getJsonCredential("lockedCredentials");
    if (!Objects.isNull(validCredentials)) {
      return new Object[][] {
        {
          validCredentials.getUsername(), validCredentials.getPassword()
        }
      };
    } else {
      return new Object[0][0];
    }
  }
}
