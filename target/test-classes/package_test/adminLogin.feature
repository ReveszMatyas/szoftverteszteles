Feature: Admin login

  Scenario: invalid login
    Given the admin login page is opened
    And the 'Username' field is filled with 'asd'
    And the 'Password' field is filled with 'asd'
    And the 'Login' button is clicked
    Then the 'Invalid credentials' message is shown in admin login

  Scenario: No data added
    Given the admin login page is opened
    And the 'Login' button is clicked
    Then the 'Invalid credentials' message is shown in admin login

  Scenario: valid login
    Given the admin login page is opened
    And the 'Username' field is filled with 'admin'
    And the 'Password' field is filled with 'password'
    And the 'Login' button is clicked
    Then the admin page is shown

