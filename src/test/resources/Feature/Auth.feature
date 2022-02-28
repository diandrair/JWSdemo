@auth
Feature: User Sign Up Registration and Sign In Feature
  @signUp
  Scenario Outline: : I should be able to create new account
    Given  I am on homepage
    When I go to authentication page
    And I input email to create account and click create account
    And I select "<gender>"
    And I enter my name as "<firstName>" and "<lastName>"
    And Verify entered email and enter my password
    And I enter my dob as "<date>", "<month>", "<years>"
    And I enter "<company>"
    And I enter my address as "<address>", "<city>", "<state>", "<postalCode>", "<country>"
    And I enter my contact as "<phone>" and "<mobile>"
    Then I can see my name as "<firstName>" and "<lastName>" on my account page then sign out

    Examples:
      | gender | firstName | lastName | date | month | years | company | address       | city | state | postalCode | country  | phone | mobile    |
      | MALE   | John      | Doe      |  5   |  5    | 1996  | Google  |Boulevard Road | Orem | 44    | 84097      | 21| 14045 | 0877889987|

  @signIn
  Scenario Outline: : I should be able login using registered account
    Given I am on authentication page
    And I enter "<email>" and "<password>" to login
    Then I can see my name on my account page then sign out
    Examples:
      | email                | password    |
      | JWSexam239@gmail.com | Password621 |
