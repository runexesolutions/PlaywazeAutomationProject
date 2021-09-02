@Login
Feature: Community Administrator  Register  into the system

@LoginValidUser
Scenario: Login Playwaze application using Valid User
Given Start Execution for Login Feature "LoginValidUser"
Given User open the playwaze url
When Community Administrator provides valid username & password Clicks on sign in option
Then Community Administrator should successfully log into the application. 

@LoginInValidUser
Scenario: Login Playwaze application using Valid User
Given Start Execution for Login Feature "LoginInValidUser"
Then Community Administrator should successfully log into the application. 
