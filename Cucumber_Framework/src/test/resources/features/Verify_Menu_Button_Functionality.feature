@GetCEOName
Feature: This feature is to test few functionalities from OrangeHRM app

  Scenario: This test is to verify Time and directory functionality from OrangeHRM app menubar
    Given the user is logged in successfully and is on HomePage
    When the user clicks on the directory option from the Menu bar
    And the user clicks on the time option from the Menu bar
    Then verify user is able to see view button in time page
    
