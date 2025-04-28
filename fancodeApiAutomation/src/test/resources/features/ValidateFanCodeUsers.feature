Feature: Validate FanCode Users Todo Completion

  Scenario: Verify that FanCode city users have completed more than 50% of their todos
    Given I fetch all the users belonging to FanCode city
    And I fetch all todos grouped by userId
    Then I verify that each FanCode user has completed more than 50% of their todos