Feature: SaceDemo Login funcationality

  Scenario: Login funcationality validation with valid credential
    Given open login page
    When user enter valid username and password
    And click on login button
    Then user navigate to the HomePage
     