package com.playwaze.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReUsableMethods {

	private WebDriver driver;
	
	public ReUsableMethods() {
		this.driver=SetUpClass.getDriver();
	}
	
	
	
	public void Click_button(By Object) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(Object));
		driver.findElement(Object).click();
	}
	
	public void Type(By Object, String Value) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfAllElementsLocatedBy(Object));
		if(driver.findElement(Object).isEnabled() & Value!=null) {
			driver.findElement(Object).sendKeys(Value);
		}
	}
	
	public void VerifyElementDisplayed(By obBy) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfAllElementsLocatedBy(obBy));
	}

}
