Feature: To create User Account to use the application

@Registration
Scenario: to create register account for the users

    Given The user is on the home page
    When he clicks on the My account and Create Account
    And he enters the valid details
        | FirstName | LastName | Email              | Telephone  | Password | ConfirmPassword |
        | Tamil     | Arasu    | Tamilu@gmail.com  | 9876543210 | pass1234 | pass1234        |
        | Tamil     | Arasu    | Tamil1@gmail.com  | 9876543210 | pass123  | pass123         |
    And he accepts the policy and clicks on continue
    Then check "Your Account Has Been Created!"