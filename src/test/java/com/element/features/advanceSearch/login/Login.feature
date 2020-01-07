@login
Feature: Login feature
  As a user
  I want to login the application
  So they can use the system

  Scenario: Login as a admin user
    Given I logged in as Admin user
    Then  I should see "HEY ADMIN USER," welcome message for admin user
  Scenario: Login as a analyst  user
    Given I logged in as analyst user
    Then  I should see "HEY ANALYST USER," welcome message for analyst user