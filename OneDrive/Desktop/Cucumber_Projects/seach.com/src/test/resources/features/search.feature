#Author:


@regression
Feature: Google Search

  As a user
  I want to search for something
  So that I can find what I am looking for

@smoke
  Scenario Outline: Search for a keyword
    Given I am on the Google search page
    When I search for "<keyword>"
    Then I should see the search results
    
    | keyword                     |
    | cucumber BDD selenium java  |