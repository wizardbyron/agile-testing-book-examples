Feature:
  As a bank account owner
  I want have a new bank account
  So that I can deposit, withdraw, auto-record my account balance

  Scenario: User has no account
    Given I have no account
    When I open a new account
    Then the account balance is 0.00

#  Scenario: User has an account already
#    Given I have an account with balance 100.00
#    When I withdraw 100.00
#    Then My account balance is 0.00
