Feature: Google search feature
  using this feature end user will be able to serach blogs, website links, maps
  
  @Smoke
  Scenario: using this feature user able to serach important information on multipal blogs
    Given User is on google home page
    When User enter 'Agile Methodology' in serach box
    And enter 'submit' button
    Then google serach engin should display all links for blogs associated with 'Agile Methodology'

@Regression
  Scenario: User want to use google map to  find the distance between 'Pune and Mumbai'
    Given User is on google home page
    When User enterd 'Pune Mumbai Distance' in serach box
    And Clicked on submit button
    Then google serach engin should open google map between 'Pune and Mumbai' and also show distance in KM
    
@Smoke
  Scenario: User want to translate 'Cucumber' word from 'English language' to 'French language'
    Given User is on google home page
    When User enterd 'Cucumber' in english language text box
    And Clicked on submit button
    Then google serach engin should tanslate 'Cucumber' word into 'French language'