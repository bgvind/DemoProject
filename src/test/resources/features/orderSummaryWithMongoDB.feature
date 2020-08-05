Feature: As a user I should be able to verify the funtionality in workorder history page

  Scenario: As a user I should be able to see the workorder history
    Given I login to serviceInsight "data1"
    And I navigate to WorkOrderHistory Page
    When I enter fromDate  greater than toDate
    Then I should see an alert message
