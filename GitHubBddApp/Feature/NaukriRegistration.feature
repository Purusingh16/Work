Feature: Naukri Registration feature
	using above fetaure user can able to use register -in services

@NaukriSmokeTesting
Scenario: User is creating naukri account using valid set of credentials
	Given User is on naukri registration Page
 	When user enter valid name and email ID
 	When user enter create password and mobile number 
 	When user select total work experience 4 year and 4 months
 	Then user should able to regeister on naukri registration page
 	
