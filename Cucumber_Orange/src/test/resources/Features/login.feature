@LoginPage
Feature: Login Feature

  Scenario: User should be able to login to Orange HRM Website
    Given User is on the Login Page
    When User enters Username and Password as "Admin" and "admin123"
    And User clicks on Login Button
    Then User should be able to login to the website

  Scenario: User not able to login on incorrect username
    Given User is on the Login Page
    When User enters Username and Password as "Admin" and "admin12"
    And User clicks on Login Button
    Then Error message should be displayed

  Scenario: User navigates to Facebook Page on clicking Facebook icon
    Given User is on the Login Page
    When User clicks on Facebook link
    Then Facebook page of the company should be opened

  Scenario: Validation of footer content
    Given User is on the Login Page
    Then Link to Orange HRM should be displayed with link text "OrangeHRM, Inc"
    And copyright message with content "© 2005 - 2022" should be displayed
    And following message should be displayed ". All rights reserved."

  Scenario Outline: Negative Testing for Login
    Given User is on the Login Page
    When User enters "<Username>" and "<Password>"
    And User clicks on Login Button
    Then "<ErrorMessage>" should be displayed

    Examples: 
      | Username | Password | ErrorMessage             |
      | Admin    | asdfgh   | Invalid credentials      |
      | Admin    |          | Password cannot be empty |
      |          | admin123 | Username cannot be empty |
