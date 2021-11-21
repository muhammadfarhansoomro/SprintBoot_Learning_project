Feature: Home Page Search Tests

  @wip
  Scenario Outline: User can do a search from the home page
    Given I search "<Suchtbegriff>" in the search input of the home page
    When I press the search button in the home page
    Then the links are displayed on the results page
    Examples:
      |  Suchtbegriff  |  Password  |
      |  Selenium      |  12345678  |
      |  Junit         |  12345679  |
      |  TestNG        |  12345670  |
      |  Farhan        |  12345670  |