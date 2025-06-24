Feature: Adding Rooms
# SOMETIMES Selenium does not find the "RoomName" element even though it is accessed via an existing id.
# It's probably an error in selenium itself?

  Background:
    Given the admin login page is opened
    And the 'Username' field is filled with 'admin'
    And the 'Password' field is filled with 'password'
    And the 'Login' button is clicked

  Scenario: Adding room with correct data
    Given the 'RoomName' field is filled with '105'
    And the 'RoomType' selector is set to "Single"
    And the 'RoomAccessible' selector is set to "false"
    And the 'RoomPrice' field is filled with "100"
    And the room count is saved into memory
    When the 'CreateRoom' button is clicked
    Then the room count should change to roomCount + 1

  Scenario Outline: Adding rooms with incorrect data
    Given all rooms are deleted
    And the 'RoomName' field is filled with "<roomName>"
    And the 'RoomType' selector is set to "<roomType>"
    And the 'RoomAccessible' selector is set to "<roomAccessible>"
    And the 'RoomPrice' field is filled with "<roomPrice>"
    When the 'CreateRoom' button is clicked
    Then the number of rooms should be <roomCount>

    Examples:
      | roomName | roomType | roomAccessible | roomPrice | roomCount |
      | 106      | Single   | false          | 0         | 0         |
      |          | Single   | false          | 100       | 0         |
      | 107      | Suite    | true           | 1000      | 0         |


