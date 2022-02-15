Feature: My Info Page Features

  Background: 
    Given User in on Dashboard Page
    Then User clicks on My Info page menu

  Scenario: User should be able to add membership
    Given User is on the MyInfo page
    When User clicks on Memberships Menu
    And User clicks on Add Membership button
    And User selects the Membership "British Computer Society (BCS)"
    And User clicks on Save
    Then Membership should be added
    
    Scenario: Upload File successfully
    Given User is on the MyInfo page
    When User clicks on Memberships Menu
    And User clicks on Add Attachments button
    And user attaches the file
    And user clicks on Upload button
    Then File should be uploaded successfully
