Feature: Amazon Search Functionality

  Background: launched Amazon mob app
    Given App is lunched

  Scenario: [Check filter by department in Deals and Promotions page]
    Given Home Page is Loaded
    When User Filter Today Deals by Software Department
    Then Deals should be filtered by Software Departments
