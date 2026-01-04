Feature: Login functionality

  As a user
  I want to login to the application
  So that I can access the system based on my credentials
  @Sanity @Smoke
  Scenario Outline: Login with valid credentials
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user clicks on Submit button
    Then user should be logged in successfully
    Examples:
      | username | password |
      | student | Password123 |
  @Regression
  Scenario Outline: Login with invalid credentials
    Given user is on login page
    When user enters invalid "<username>" and "<password>"
    And user clicks on Submit button
    Then user should see an error message
    Examples:
      | username | password |
      | student  | password1234 |
