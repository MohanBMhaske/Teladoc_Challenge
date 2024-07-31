Feature: Webtables Automation

  Scenario: Add a user and validate the user has been added to the table
    Given the user is on the webtables page
    When the user adds a new user with Firstname "Mohan",LastName "Mhaske", username "MohanMhaske", password "12345678" email "mohan.mhaske@example.com" and Mobile Number is "9876543212"
    Then the user should see "Mohan" in the table

  Scenario: Delete the user "novak" from the table and validate the user has been deleted
    Given the user is on the webtables page
    When the user deletes the user with name "Novak"
    Then the user should not see "Novak" in the table
