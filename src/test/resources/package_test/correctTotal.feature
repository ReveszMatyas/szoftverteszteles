Feature: Checking total

    Scenario: Booking for one day the Single bedroom
    Given the home page is opened
    And the 'BookSingle' button is clicked
    When the 'Reserve' button is clicked
    Then the total should read '£140'


  Scenario: Booking for one day the Double bedroom
    Given the home page is opened
    And the 'BookDouble' button is clicked
    When the 'Reserve' button is clicked
    Then the total should read '£190'