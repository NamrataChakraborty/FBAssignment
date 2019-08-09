$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('assignment1\FbLoginPostStatus.feature');
formatter.feature({
  "line": 1,
  "name": "Facebook Login and Post Status Message",
  "description": "",
  "id": "facebook-login-and-post-status-message",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 11,
  "name": "Login to Facebook and post a status message",
  "description": "",
  "id": "facebook-login-and-post-status-message;login-to-facebook-and-post-a-status-message;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User opens the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User navigates to Facebook",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User should be able to login using Username \"assignmentTest.User\" and Password \"Pass1234\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "User should be able to post a status message as \"Hello World\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.User_opens_the_browser()"
});
formatter.result({
  "duration": 11432274289,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.User_navigates_to_Facebook()"
});
formatter.result({
  "duration": 6565801016,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "assignmentTest.User",
      "offset": 45
    },
    {
      "val": "Pass1234",
      "offset": 80
    }
  ],
  "location": "StepDefinition.User_should_be_able_to_login_using_Username_and_Password(String,String)"
});
formatter.result({
  "duration": 33768445242,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hello World",
      "offset": 49
    }
  ],
  "location": "StepDefinition.User_should_be_able_to_post_a_status_message_as(String)"
});
formatter.result({
  "duration": 10598199124,
  "status": "passed"
});
});