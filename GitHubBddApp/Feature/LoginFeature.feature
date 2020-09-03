Feature: Github Login feature
	using above fetaure user can able to use singn -in services

@Smoke
Scenario: User is trying to singin in git hub account using Invalid set of credentials
	Given User is on GitHub login Page
 	When user enter Invalid username and password 
 	Then 'Incorrect username or password.' Message should display
 	
@Smoke1
Scenario: User is trying to singin in GitHub using valid set of credentials
 Given User is on GitHub login Page
 When user enter valid username and password 
 Then user should successfully Sigin on his Github Account 