Feature: Facebook Login and Post Status Message

  Scenario Outline: Login to Facebook and post a status message
    Given User opens the browser
    When User navigates to Facebook
    Then User should be able to login using Username "<Username>" and Password "<Password>"
    And User should be able to post a status message as "<Message>"

    Examples: 
      | Username            | Password | Message     |
      | assignmentTest.User | Pass1234 | Hello World |
