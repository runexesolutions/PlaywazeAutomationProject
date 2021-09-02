package com.playwaze.stepdefination;


import org.openqa.selenium.WebDriver;

import com.playwaze.pageobject.LoginPage;
import com.playwaze.reports.ExtentManager;
import com.playwaze.util.PropertyFileReader;
import com.playwaze.util.SetUpClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginValidation {
	
	WebDriver driver = SetUpClass.getDriver();
	PropertyFileReader Prop = new PropertyFileReader();
	LoginPage login = new LoginPage();
	
	
	
	
	 @Given("^Start Execution for Login Feature \"([^\"]*)\"$")
	 public void AssignTestCaseNo(String arg1) {
		
		 ExtentManager.CreateTest(arg1);
	}
	
	 @Given("^User open the playwaze url$")
	 public void OpenPlaywazeURL() throws Exception {
		 driver.get(Prop.GetProperty("Url"));
		 Thread.sleep(4000);
		 ExtentManager.UpdatePass("URL Opened Successfully");
	 }
	 
	 @When("^Community Administrator provides valid username & password Clicks on sign in option$")
	 public void LoginplaywazeWeb() throws Exception {
		 login.Click_Accept();Thread.sleep(2000);
		 login.ClickLogin();Thread.sleep(2000);
		 login.EnterUserName(Prop.GetProperty("Username"));Thread.sleep(3000);
		 login.EnterPassword(Prop.GetProperty("Password"));Thread.sleep(3000);
		 login.ClickSign();Thread.sleep(4000);
		 ExtentManager.UpdatePass("Sign in Successfully");
		 ExtentManager.UpdateFail("Fail", "AAA");
	 }
	

}
