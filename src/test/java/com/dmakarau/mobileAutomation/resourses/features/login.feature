@login_feature
Feature: Login screen scenarios

  Scenario: Login screen
    Given The app is launched on the Welcome screen
    When I tap the login button
    Then The login screen is opened

  Scenario: Login functionality
    Given The app is launched on the Welcome screen
    When The user is on the login screen
    And I login with the valid credentials


