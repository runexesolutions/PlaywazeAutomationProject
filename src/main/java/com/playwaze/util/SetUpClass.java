package com.playwaze.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SetUpClass {
	
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static final ThreadLocal<String> browser = new ThreadLocal<String>();
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static String getBrowser() {
		return browser.get();
	}
	
	public static void setBrowser(String Browser) {
		browser.set(Browser);
		
	}
	
	public static void setDriver(String browser) {
		WebDriver createdriver;
		
		if(browser.toLowerCase().trim().equals("chrome")) {
			
			String chromepath = System.getProperty("user.dir")+"/libs/chromedriver.exe" ;
			System.setProperty("webdriver.chrome.driver", chromepath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", "/directory/path");
			options.setExperimentalOption("prefs", prefs);
			options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability("acceptInsecureCerts", true);
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			createdriver = new ChromeDriver(options);
			driver.set(createdriver);
			
		}else if (browser.toLowerCase().trim().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/libs/geckodriver.exe");
			driver.set(new FirefoxDriver());
		}
		
	}
	
	public static void closeBrowser()
	{
		driver.get().close();
		driver.remove();
	}
	
	
	
}
