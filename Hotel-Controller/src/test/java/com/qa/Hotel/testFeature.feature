Feature: Testing Automation using REST

Scenario: Testing both a status code and a field
  Given all a new entry is made
  When we get the id from post
  And preform a put on the id
  And we get the id from post and delet that item
  Then Verify the code
  And check that the id is not in the database
