Feature: Simple Feature
  @Smoke
    Scenario: Search for flights on cleartrip
    Given I navigate to the cleartrip homepage
    And I have selected from and to options
    When I click on search flights