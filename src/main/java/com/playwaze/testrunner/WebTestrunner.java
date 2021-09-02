package com.playwaze.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.playwaze.reports.ExecutionReport;
import com.playwaze.reports.ExtentManager;
import com.playwaze.util.SetUpClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features = "./BDDFeatures/",
        glue = {"com.playwaze.stepdefination"},
        tags = {"@Login"},
        plugin = { "pretty","json:target/cucumberreports.json", "html:target/cucumber"}, monochrome=true
    )

public class WebTestrunner {
 
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@Parameters({"browser"})
	@BeforeClass(alwaysRun=true)
	public void RunTestcase(String browser) {
		
		SetUpClass.setBrowser(browser);
		SetUpClass.setDriver(browser);
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
	}
	
	@Test(groups = "cucumbers", description = "Runs Cucumber Features", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
		try {
			ExecutionReport.ClassName= cucumberFeature.getCucumberFeature().getGherkinFeature().getName();
			ExtentManager.createInstance();
			//ExecutionReport.CreateReportFile();
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    @DataProvider(name = "features")
    public Object[][] features() {
			return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        SetUpClass.getDriver().quit();
        ExtentManager.extent.flush();
    }
	
	
	
	
	
}
