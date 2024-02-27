Feature: To get data from dynamic table

  Background: refresh the page
  Given open new tab and close

  Scenario: Get data from dynamic table where table contents changing after refresh
    Given user is successfully logged in
    When user navigate to dynamic table webpage
    Then get Network  and Memory of Chrome Browser
