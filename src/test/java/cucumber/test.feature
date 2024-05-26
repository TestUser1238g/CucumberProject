Feature: Login to Portal and do some actions
  I want to use this template for my feature file

Background: Launch the application
Given Login to portal


  @Regression
  Scenario Outline: Login to portal and verify the admin page
    Given Click on Admin button
    Then I verify the <title> of the page
    And logout the Application

    Examples: 
      | title  | 
      | Admin  |    
