Feature: Multiple rows of data
  @Smoke
  Scenario Outline: Search for flights on cleartrip
    Given I navigate to the cleartrip homepage
    And I select flights with "<From>" and "<To>" options
    When I click on search flights
    Then list of flight options will be visible
    Examples:
    |From                                           |To                                                |
    |New Delhi, IN - Indira Gandhi Airport |Hyderabad, IN - Rajiv Gandhi International |
    |New Delhi, IN - Indira Gandhi Airport |Hyderabad, IN - Rajiv Gandhi International |