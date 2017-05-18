Feature: Simple feature with passing arguments

  @Smoke
  Scenario: Search for round trip flight options from New Delhi to Hyderabad
    Given I navigate to the cleartrip homepage
    And choose the round trip option
    And I select flight with "New Delhi" and "Hyderabad, IN" options
    When I click on search flights
    Then list of flight options will be visible

  @Smoke
  Scenario Outline: Search for round trip flights (Scenario by Example)
    Given I navigate to the cleartrip homepage
    And choose the round trip option
    And I select flights with "<From>" and "<To>" options
    When I click on search flights
    Then list of flight options will be visible
    Examples:
      |From      |To           |
      |New Delhi |Hyderabad, IN|
      |Mumbai    |New Delhi    |