Feature: Checking total

    Scenario: Booking for one day the Single bedroom
    Given the home page is opened
    When the 'BookSingle' button is clicked
    #When the 'Reserve' button is clicked
    Then the total should read '£140'


  Scenario: Booking for one day the Double bedroom
    Given the home page is opened
    When the 'BookDouble' button is clicked
    Then the total should read '£190'

  Scenario: Booking for multiple days the Single bedroom
    Given the home page is opened
    And the 'CheckInDate' field is filled with '10/07/2025'
    And the 'CheckOutDate' field is filled with '15/07/2025'
    And the 'BookSingle' button is clicked
    Then the total should read '£540'
