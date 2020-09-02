Feature: Google search feature
using this feature end user will be able search blogs, website links, maps

@Smoke
Scenario: using this feature user able to search important information on multiple blogs
Given User is on google home page
When User enter 'Agile Methodology' in search box
And enter 'submit' button
Then google search engine should display all links for blog associated with 'Agile Methodlogy'

@Regression
Scenario: User want to use google map to find the distance between 'Pune and Mumbai'
Given User is on google home page
When User enterd 'Pune Mumbai Distance' in search box
And Click on submit button
Then google search engin should open google map between 'Pune and Mumbai' and also show distance in KM

@Smoke
Scenario: User want ot translate 'Cucumber' word from 'English language' to 'French language'
Given User is on google home page
When User enterd 'Cucumber' in english language text box
And Clicked on submit button
Then google search engine should translate 'Cucumber' word into 'Fench language'


