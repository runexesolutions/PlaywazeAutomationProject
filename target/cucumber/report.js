$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Community Administrator  Register  into the system",
  "description": "",
  "id": "community-administrator--register--into-the-system",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Login Playwaze application using Valid User",
  "description": "",
  "id": "community-administrator--register--into-the-system;login-playwaze-application-using-valid-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@LoginValidUser"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Start Execution for Login Feature \"LoginValidUser\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User open the playwaze url",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Community Administrator provides valid username \u0026 password Clicks on sign in option",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Community Administrator should successfully log into the application.",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LoginValidUser",
      "offset": 35
    }
  ],
  "location": "LoginValidation.AssignTestCaseNo(String)"
});
formatter.result({
  "duration": 81349400,
  "status": "passed"
});
formatter.match({
  "location": "LoginValidation.OpenPlaywazeURL()"
});
formatter.result({
  "duration": 12542994100,
  "status": "passed"
});
formatter.match({
  "location": "LoginValidation.LoginplaywazeWeb()"
});
formatter.result({
  "duration": 22990967200,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 12,
  "name": "Login Playwaze application using Valid User",
  "description": "",
  "id": "community-administrator--register--into-the-system;login-playwaze-application-using-valid-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@LoginInValidUser"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Start Execution for Login Feature \"LoginInValidUser\"",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "Community Administrator should successfully log into the application.",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LoginInValidUser",
      "offset": 35
    }
  ],
  "location": "LoginValidation.AssignTestCaseNo(String)"
});
formatter.result({
  "duration": 115300,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});