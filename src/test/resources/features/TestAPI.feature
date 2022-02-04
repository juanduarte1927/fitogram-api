# language: en

@jsonPlaceHolder
Feature: : API Posts from user in Blog

  **How** user of the application
  **Wants** can use the API's available
  **To*** get the posts made from a user

  @validateEmailFormat
  Scenario Outline: : Validate the e-mail format in comments of the posts made by a user
    Given that Delphine is a user registered
    When the system fetch the user data
      | <username> |
    When she wants to get all their posts and comments
    Then should be validated the e-mail format from the comments

    Examples:
      | username  |
      | Delphine |
