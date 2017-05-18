Feature: Sample feature files

  @Manual
  Scenario: Login to Gmail functionality
    Given I navigate to google mail
    And Enter username and password
    When I click on submit
    Then I should see my mailbox

  @Smoke
  Scenario: Search for one way flight options from Hyderabad to Banglore
    Given I navigate to the cleartrip homepage
    And I select flight with "Hyderabad, IN" and "Bangalore, IN" options
    When I click on search flights
    Then list of flight options will be visible