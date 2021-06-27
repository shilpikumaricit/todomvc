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

  @home_page @home_page_view_all_todo
  Scenario Outline:: View all todo
    Given User navigates to the website
    When a user enter todo "Meeting with team"
    When a user enter todo "Sprint planning"
    When user click on All button
    Then User is displayed with "<nbOfResultsToSearch>" results

    Examples:
      | nbOfResultsToSearch |
      | 2 |

  @home_page @home_page_remove_todo
  Scenario:: Remove todo
    Given User navigates to the website
    When a user enter todo "Meeting with team"
    When user click on Active button
    Then "Meeting with team" is displayed in the results
    Then user click on radio button for todo item "Meeting with team"
    Then "Meeting with team" is removed from the Active todo list


  @home_page @home_page_Add_2_remove_1_todo
  Scenario:: Add 2 and Remove 1 todo
    Given User navigates to the website
    When a user enter todo "Meeting with team"
    When a user enter todo "Sprint planning"
    When user click on Active button
    Then "2" todo is displayed in "Active" results
    Then user click on radio button for todo item "Meeting with team"
    Then "1" todo is displayed in "Active" results
    Then "2" todo is displayed in "All" results