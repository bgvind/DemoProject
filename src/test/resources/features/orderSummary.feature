Feature: As a user I should be able to verify the funtionality in workorder history page

  Scenario: As a user I should be able to see the workorder history
    Given I login to "https://tst.mainstreamsasp.com/WEB00344CFG/Logon.aspx" using username "AutomatedTester" and Password "Automation!2020"
    And I navigate to WorkOrderHistory
    When I enter fromDate "8/12/2020" greater than toDate "8/1/2020"
    Then I should get an alert message  "- From Date should be less than To Date."
