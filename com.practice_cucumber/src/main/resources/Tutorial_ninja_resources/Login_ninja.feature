Feature: Login feature of ninja

@validInput
Scenario Outline: Login with valid credentials
	Given The user in the home page 
	When he clicks on the My account and then Login 
	And he enters email "<email>" and password "<password>"
	Then check the Account Login Successful

Examples:
	| email                   | password   |
	| acctamil151@gmail.com  | Tamilarasu |
	| acctamil151@gmail.com  | Tamilarasu |