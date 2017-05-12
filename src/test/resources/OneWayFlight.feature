Feature: Simple Feature
  @Smoke
    Scenario: Search for One Way flight options
    Given I navigate to the cleartrip homepage
    And I have selected from and to options
    When I click on search flights