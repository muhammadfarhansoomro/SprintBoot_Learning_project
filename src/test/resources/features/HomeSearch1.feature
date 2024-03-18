Feature: Home Page Search Tests


  Scenario Outline: User can do a search from the home page
    Given I search "<Suchbegriff>" in the search input of the home page
    When I press the search button in the home page
    Then the links are displayed on the results page
    And I will verify if the Results Page contain "TestNG"

    @Regression
    Examples:
      |  Suchbegriff   |  Password  |
      |  Selenium      |  12345678  |
      |  Junit         |  12345679  |
      |  TestNG        |  12345670  |
      |  Test          |  12345670  |

 #   @Regression
 #   Examples:
 #     |  Suchbegriff   |  Password  |
 #     |  Selenium      |  12345678  |
 #     |  Junit         |  12345679  |
 #     |  TestNG        |  12345670  |
 #     |  Test          |  12345670  |