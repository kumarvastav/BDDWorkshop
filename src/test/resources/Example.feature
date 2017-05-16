Feature: Gmail Login
  @Manual
  Scenario: Login to Gmail functionality
    Given I navigate to google mail
    And Enter username and password
    When I click on submit
    Then I should see my mailbox