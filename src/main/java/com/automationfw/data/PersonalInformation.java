package com.automationfw.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PersonalInformation {
  private final String firstName;
  private final String lastName;
  private final String postalCode;

  @JsonCreator
  public PersonalInformation(@JsonProperty("first-name") String firstName,
                             @JsonProperty("last-name") String lastName,
                             @JsonProperty("postal-code") String postalCode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.postalCode = postalCode;
  }
}
