Feature: Dashboard Feature

  Scenario: Directory Page should be displayed on clicking Directory Menu
    Given User is on the Dashboard Page
    When User clicks on the Directory menu
    Then Directory Page should be displayed

  Scenario: Validate the Quick Launch Links
    Given User is on the Dashboard Page
    Then Quick Launch section should be displayed
    And Quick Launch section should have the below links
      | Assign Leave | Leave List | Timesheets | Apply Leave | My Leave | My Timesheet |
