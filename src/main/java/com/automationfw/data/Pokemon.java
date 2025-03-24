package com.automationfw.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Pokemon {

  private final String requestType;
  private final String name;


  @JsonCreator
  public Pokemon(@JsonProperty("requestType") String requestType, @JsonProperty("name") String name) {
    this.requestType = requestType;
    this.name = name;
  }
}
