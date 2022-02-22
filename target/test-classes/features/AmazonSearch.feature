Feature: Amazon Search Functionality

  Background: launched Amazon mob app
    Given App is lunched

  Scenario Outline:  [Check the total displayed number of results for category Smart Home | Televisions]
    Given Home Page is Loaded
    When User Click on Shop by Department from burger menu
    And  User Select category ‘Electronics’
    And  User Choose sub-category ’TV & VIDEO’
    And  User Filter with ’HD Format’ and click show results
    Then the total number of results match the <total> displayed in filter

    Examples:
      | total |
      | 20    |




