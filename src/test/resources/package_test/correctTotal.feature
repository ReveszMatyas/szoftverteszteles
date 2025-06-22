Feature: Checking total

  Background:

    Scenario: Booking for one day the Single bedroom
    Given the home page is opened
    And the 'Book' button is clicked
    When the 'Reserve' button is clicked
    Then the total should read '£140'