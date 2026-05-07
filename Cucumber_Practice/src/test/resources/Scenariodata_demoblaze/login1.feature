Feature: To check the demoblaze website

Background:
    Given user is on Homepage

@invalidInput
Scenario Outline: Login with invalid credentials

    When user enter username as "<username>" and password as "<password>"
    And User clicks on the login button
    Then the error message seen as "<alert>"

Examples:
    | username | password | alert                                      |
    | jeevs    | 123      | Wrong password.                            |
    | jeev@    | 123      | User does not exist.                       |
    |          |          | Please fill out Username and Password.     |