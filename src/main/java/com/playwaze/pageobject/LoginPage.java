package com.playwaze.pageobject;

import org.openqa.selenium.By;

import com.playwaze.util.ReUsableMethods;

public class LoginPage {
	
	ReUsableMethods reuse;
	
	public LoginPage() {
		reuse = new ReUsableMethods();
		
	}



	public By Accept = By.xpath("//button[@class='iubenda-cs-accept-btn iubenda-cs-btn-primary']");
	public By Login = By.xpath("//a[@href='https://playwaze-uat.azurewebsites.net/login']");
	public By Username = By.xpath("//input[@id='UserName']");
	public By Password = By.xpath("//input[@id='Password']");
	public By Signin = By.xpath("//button[@class='style-button style-button-success style-button-medium']");
	public By Profileicon = By.xpath("//img[@class='h-profile-img']");
	
	
	public void Click_Accept() {
		reuse.Click_button(Accept);
	}
	
	public void ClickLogin() {
		reuse.Click_button(Login);
	}
	
	public void EnterUserName(String name) {
		reuse.Type(Username, name);
	}
	
	public void EnterPassword(String Pass) {
		reuse.Type(Password, Pass);
	}
	
	public void ClickSign() {
		reuse.Click_button(Signin);
	}
	
	public void VerifyProfile() {
		reuse.VerifyElementDisplayed(Profileicon);
	}

}
