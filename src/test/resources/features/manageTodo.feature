Feature: manage my todo list
  As a customer, I want to place an order for searched item

  @home_page @home_page_display
  Scenario: User should be able to launch the application
    Given User navigates to the website

  @home_page @home_page_add_todo
  Scenario Outline:: Add todo
    Given User navigates to the website
    When a user enter todo "Meeting with team"
    Then "Meeting with team" is displayed in the first "<nbOfResultsToSearch>" results

    Examples:
      | nbOfResultsToSearch |
      | 1 |

  @home_page @home_page_remove_todo
  Scenario:: Remove todo
    Given User navigates to the website
    When a user enter todo "Meeting with team"
    When user click on Active button
    Then "Meeting with team" is displayed in the results
    Then user click on radio button for todo item "Meeting with team"
    Then "Meeting with team" is removed from the Active todo list