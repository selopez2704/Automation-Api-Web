package com.automationfw.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Credential {
  private final String type;
  private final String username;
  private final String password;

  @JsonCreator
  public Credential(@JsonProperty("type") String type, @JsonProperty("username") String username,
                    @JsonProperty("password") String password) {
    this.type = type;
    this.username = username;
    this.password = password;
  }
}