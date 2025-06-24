Feature: Reserving Room
# Sometimes #doReservation is not found by the Selenium engine. Annoying, and unpredictable.

  Background:

  Scenario Outline: incorrect phone number
    Given the home page is opened
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'asd'
    And the 'LastNameReserve' field is filled with 'asd'
    And the 'EmailReserve' field is filled with 'asdasd@gmail.com'
    And the 'PhoneNumberReserve' field is filled with '<phoneNumber>'
    When the 'ReserveNow' button is clicked
    Then the '<errorMessage>' message is shown in reservation
    Examples:
      |phoneNumber                                    |errorMessage                                       |
      |                                               |size must be between 11 and 21;must not be empty   |
      |1                                              |size must be between 11 and 21                     |
      |1111111111111111111111111111111111111111111111 |size must be between 11 and 21                     |

  Scenario Outline: incorrect email
    Given the home page is opened
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'asd'
    And the 'LastNameReserve' field is filled with 'asd'
    And the 'EmailReserve' field is filled with '<email>'
    And the 'PhoneNumberReserve' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the '<errorMessage>' message is shown in reservation
    Examples:
      |email|errorMessage                           |
      |     |must not be empty                      |
      |a    |must be a well-formed email address    |
      |aaa  |must be a well-formed email address    |
      |aaa@ |must be a well-formed email address    |
      |aaa@.com |must be a well-formed email address|

    Scenario: First name is empty
      Given the home page is opened
      And the 'BookSingle' button is clicked
      And the 'Reserve' button is clicked
      And the 'LastNameReserve' field is filled with 'asdasd'
      And the 'EmailReserve' field is filled with 'asd@gmail.com'
      And the 'PhoneNumberReserve' field is filled with '30/111/1111'
      When the 'ReserveNow' button is clicked
      Then the 'Firstname should not be blank;size must be between 3 and 18' message is shown in reservation

  Scenario: First name is too short
    Given the home page is opened
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'a'
    And the 'LastNameReserve' field is filled with 'asdasd'
    And the 'EmailReserve' field is filled with 'asd@gmail.com'
    And the 'PhoneNumberReserve' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the 'size must be between 3 and 18' message is shown in reservation


  Scenario: Last name is empty
    Given the home page is opened
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'asd'
    And the 'EmailReserve' field is filled with 'asd@gmail.com'
    And the 'PhoneNumberReserve' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the 'Lastname should not be blank;size must be between 3 and 30' message is shown in reservation

  Scenario: Last name is empty
    Given the home page is opened
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'asd'
    And the 'EmailReserve' field is filled with 'asd@gmail.com'
    And the 'PhoneNumberReserve' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the 'Lastname should not be blank;size must be between 3 and 30' message is shown in reservation

  Scenario: Successful room reservation - no date selected
    Given the home page is opened
    And the 'BookDouble' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'John'
    And the 'LastNameReserve' field is filled with 'Doe'
    And the 'EmailReserve' field is filled with 'john.doe@example.com'
    And the 'PhoneNumberReserve' field is filled with '12345678901'
    When the 'ReserveNow' button is clicked
    Then 'Booking Confirmed' is the div headline for reservation.

  Scenario: Reservation with correct data -> passes if duplicate reservation (client error), else fails.
    Given the home page is opened
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstNameReserve' field is filled with 'John'
    And the 'LastNameReserve' field is filled with 'Doe'
    And the 'EmailReserve' field is filled with 'john.doe@example.com'
    And the 'PhoneNumberReserve' field is filled with '12345678901'
    When the 'ReserveNow' button is clicked
    Then 'Application error: a client-side exception has occurred while loading automationintesting.online (see the browser console for more information).' full screen message is shown.
    # --> Crashes, even though my the credentials are correct -- supposedly server error?
    # --> Once worked properly


  Scenario: Reservation with correct data - if there is no clash of reservation it should work
    Given the home page is opened
    And the 'CheckInDate' field is filled with '10/07/2025'
    And the 'CheckOutDate' field is filled with '15/06/2025'
    And the 'BookSingle' button is clicked
    And the 'Reserve' button is clicked
    And the 'LastNameReserve' field is filled with 'Doe'
    And the 'FirstNameReserve' field is filled with 'John'
    And the 'EmailReserve' field is filled with 'john.doe@example.com'
    And the 'PhoneNumberReserve' field is filled with '12345678901'
    When the 'ReserveNow' button is clicked