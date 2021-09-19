@wip
Feature: Verify Frankfurt Info


Scenario: 
  When I send a GET request to networks
  Then Status code should be 200
  Then Frankfurt should be in Germany
  And  I should be  able get location info


