Feature: Login to Demoblaze Application

Background:
    Given User is in the dashboard page
    And User clicks on the login button

@ValidLogin @VL @Tamil
Scenario: Login with valid credentials

    When the user enters username
    And the user enters password
    And clicks on the Login
    Then the user should see the Welcome message

@InvalidLogin
Scenario: Login with invalid credentials

    When the user enters invalid username
    And the user enters invalid password
    And clicks on the Login
    Then the user should see an error alert
