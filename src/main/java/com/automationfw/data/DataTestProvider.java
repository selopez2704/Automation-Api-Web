package com.automationfw.data;

import static com.automationfw.data.CustomJsonReader.getJsonCredential;
import static com.automationfw.data.CustomJsonReader.getJsonPersonalInformation;

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

  @DataProvider(name = "complete-purchase")
  public static Object[][] testDataCompletePurchase() throws IOException {
    Credential validCredentials = getJsonCredential("validCredentials");
    PersonalInformation personalInformation = getJsonPersonalInformation();
    if (!(Objects.isNull(validCredentials) && Objects.isNull(personalInformation))) {
      return new Object[][] {
        {
          validCredentials.getUsername(),
          validCredentials.getPassword(),
          personalInformation.getFirstName(),
          personalInformation.getLastName(),
          personalInformation.getPostalCode()
        }
      };
    } else {
      return new Object[0][0];
    }
  }
}
