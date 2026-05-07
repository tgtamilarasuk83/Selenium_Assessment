Feature: To checks the demoblaze websites

Background:
    Given user is on Homepages

@invalidInput
Scenario Outline: Login with invalid credentialss
	
    When user enter username as "<username>" and passwords as "<password>" 
    | jeevs    | 123      | 
    | jeev@    | 123      | 
  
    And Users clicks on the login button
  