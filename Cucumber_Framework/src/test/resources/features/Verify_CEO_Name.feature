@GetCEOName
Feature: This feature is to get the CEO name from OrangeHRM app
Scenario Outline: This test is to verify CEO Name
	Given the user is logged in successfully and is on HomePage
	When the user clicks on the directory option from the Menu bar
	And the user selects the job title as "CEO" from the dropdown
	And clicks the search button
	Then the user should see the CEO name as "<CEO_Name>"
Examples:
|CEO_Name|
|John Smith|