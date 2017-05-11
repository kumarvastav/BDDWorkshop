Feature: Simple feature with passing arguments
  @Smoke
  Scenario: Search for flights on cleartrip
    Given I navigate to the cleartrip homepage
    And I select flight with "New Delhi, IN - Indira Gandhi Airport (DEL)" and "Hyderabad, IN - Rajiv Gandhi International (HYD)" options
    When I click on search flights
    Then list of flight options will be visible