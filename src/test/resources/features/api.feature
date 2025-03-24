@Pokeapi

Feature: GET Methods

#  @this
  Scenario: Fetch a Pokémon by providing a valid name
    Given I send a valid GET request for a pokemon name
    Then The response code should be 200