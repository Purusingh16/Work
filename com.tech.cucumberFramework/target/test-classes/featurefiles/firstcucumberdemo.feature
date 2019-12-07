#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing login scenarios


  I want to test valid and invalid login scenarios
  Background: perform generic steps
  
   Given User should open application "http://automationpractice.com" on "firefox" browser
    When User clicks on sign in link

  @sanity
  Scenario: Login with valid credentials
   
    And User enters "seleniumpr@gmail.com" in username field
    And User enters "seleniumpr" in password field
    And user clicks Signin button
    Then User should be login 
    
    @regression
    Scenario: Login with Invalid credentials
    
    And User enters "seleniumpr@gmail.com" in username field
    And User enters "selenium" in password field
    And user clicks Signin button
    Then User should not be login 
    
    @sanity @regression
    Scenario Outline: Data Driven testing/checking for all invalid combinations
   
    
    And User enters "<email>" in username field
    And User enters "<password>" in password field
    And user clicks Signin button
    Then User should not be login
     
     Examples:
              |email|password|
              |seleniumpr@gmail.com|desire123|
              |test12@test.com|test123|
              |test123test.com|desire123| 
    
 
    

 