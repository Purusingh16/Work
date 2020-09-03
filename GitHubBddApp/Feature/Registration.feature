Feature: Github Registure feature
	using above fetaure user can able to use Register -in services

@Regression
Scenario: User is tyring to create git hub account using Username, Email, Password with set of credentials
	Given User is on GitHub Register Page
 	When user enter valid username, valid Email and password 
 	Then user should successfully Sign up for GitHub on his Github Account
 	
