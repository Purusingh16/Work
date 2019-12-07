
Feature: Test Facebook Smoke Scenario

Scenario: Test login with Valid Credentials
Given Open Firefox and Start Application
When I enter Valid "dipusingh797@gmail.com" and Valid "password@123"
Then User should be able to login Successfully 