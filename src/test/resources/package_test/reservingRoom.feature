Feature: Reserving Room

  Background:

  Scenario Outline: incorrect phone number
    Given the home page is opened
    And the 'Book' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstName' field is filled with 'asd'
    And the 'LastName' field is filled with 'asd'
    And the 'Email' field is filled with 'asdasd@gmail.com'
    And the 'PhoneNumber' field is filled with '<phoneNumber>'
    When the 'ReserveNow' button is clicked
    Then the <errorMessage> message is shown
    Examples:
      |phoneNumber|errorMessage
      |           |<ul><li>size must be between 11 and 21</li><li>must not be empty</li></ul>
      |1          |<ul><li>size must be between 11 and 21</li></ul>
      |1111111111111111111111111111111111111111111111|<ul><li>size must be between 11 and 21</li></ul>

  Scenario Outline: incorrect email
    Given the home page is opened
    And the 'Book' button is clicked
    And the 'Reserve' button is clicked
    And the 'FirstName' field is filled with 'asd'
    And the 'LastName' field is filled with 'asd'
    And the 'Email" field is filled with '<email>'
    And the 'PhoneNumber' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the <errorMessage> message is shown
    Examples:
      |email|errorMessage
      |     |<ul><li>must not be empty</li><li>size must be between 3 and 18</li></ul>
      |a    |<ul><li>must be a well-formed email address</li><li>size must be between 3 and 18</li></ul>
      |aaa  |<ul><li>must be a well-formed email address</li></ul>
      |aaa@ |<ul><li>must be a well-formed email address</li></ul>

    Scenario: First name is empty
      Given the home page is opened
      And the 'Book' button is clicked
      And the 'Reserve' button is clicked
      And the 'LastName' field is filled with 'asdasd'
      And the 'Email" field is filled with 'asd@gmail.com'
      And the 'PhoneNumber' field is filled with '30/111/1111'
      When the 'ReserveNow' button is clicked
      Then the '<ul><li>Firstname should not be blank</li><li>size must be between 3 and 18</li></ul>' message is shown

  Scenario: First name is too short
    Given the home page is opened
    And the 'Book' button is clicked
    And the 'Reserve' button is clicked
    And the 'FistName' field is filled with 'a'
    And the 'LastName' field is filled with 'asdasd'
    And the 'Email" field is filled with 'asd@gmail.com'
    And the 'PhoneNumber' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the '<ul><li>size must be between 3 and 18</li></ul>' message is shown



  Scenario: Last name is empty
    Given the home page is opened
    And the 'Book' button is clicked
    And the 'Reserve' button is clicked
    And the 'FistName' field is filled with 'asdasd'
    And the 'Email" field is filled with 'asd@gmail.com'
    And the 'PhoneNumber' field is filled with '30/111/1111'
    When the 'ReserveNow' button is clicked
    Then the '<ul><li>Lastname should not be blank</li><li>size must be between 3 and 18</li></ul>' message is shown

