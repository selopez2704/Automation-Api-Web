@Pokeapi

Feature: GET Methods

  @this
  Scenario: Fetch a Pokémon by providing a valid name
    Given I send a valid GET request for a pokemon name
    Then The response code should be 200

  @this
  Scenario: Fetch a Pokémon by providing a invalid name
    Given I send a invalid GET request for a pokemon name
    Then The response code should be 404

  @this
  Scenario: Fetch a Pokémon by providing a uppercase name
    Given I send a uppercase GET request for a pokemon name
    Then The response code should be 200