@Login
Feature: Login functionality

  As a user
  I want to login to the application
  So that I can access the system based on my credentials
  @Smoke
  Scenario Outline: Login with valid credentials
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user clicks on Submit button
    Then user should see "<result>"
    Examples:
      | username | password | result |
      | student | Password123 | logged-in-successfully |
      | student | Password1234 | practice-test-login |
