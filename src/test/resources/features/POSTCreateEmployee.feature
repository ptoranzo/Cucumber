Feature: Validating Syntax HRMS API's
Background: 
Given user generates token

@APITEST
Scenario: This test will check to see if an Employee is created 
Given user call createEmployee API
When User retrieves response
Then status code is 200
Then User validates employee is created