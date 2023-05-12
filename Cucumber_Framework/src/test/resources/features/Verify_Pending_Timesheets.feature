@timesheets
Feature: This feature is to get the pending timesheet
Scenario Outline: This test is to verify pending timesheet
	Given the user is on HomePage
	When the user clicks on time option from the Menu 
	And the user enters name as "John Smith"
	And clicks on the view button
	Then the user should see the message as "<message>"
Examples:
|message|
|No Timesheets Found|