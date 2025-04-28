Feature: Login Functionality

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should be redirected to the homepage

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |