Feature:Creating test for regres-in API pages
  @smoke
  Scenario:Creating Get call for single user
    Given I am baseURI of the regres application
    When I passing endpoint for single user
    Then I validate the status code
    And I validate email

@smoke
  Scenario:Creating post call for single user
    Given I am baseURI of the regres application
    When I passing endpoint for create user
    Then I validate the status code of
  And I Validate id

@smoke
Scenario:Creating put call for single user
  Given I am baseURI of the regres application
  When I passing endpoint for update user
  Then I validate the status code
  And validate updated time

  @smoke
  Scenario:Creating delete call for single user
    Given I am baseURI of the regres application
    When I passing endpoint for delete user
    Then I validate the status code for delete


  @smoke
  Scenario:Creating post2 call for single user
    Given I am baseURI of the regres application
    When I passing endpoint for postcall
    Then I validate the status code
  @smoke
  Scenario:Creating getlist call for single user
    Given I am baseURI of the regres application
    When I passing endpoint for list of users
    Then I validate the status code
