package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.Constants;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.LoginPage;
import testbase.TestBase;
import utilities.CommonUtils;

public class Hooks {
   
	private static String scenarioName=null;
	
	private static final Logger LOG = LogManager.getLogger(Hooks.class);

	@Before("@LoginPage")
	public void initDriver(Scenario scenario) {

		try {
				scenarioName = scenario.getName();
			
				CommonUtils.getInstance().readConfig();
				LOG.info("Launching Browser");
				TestBase.launchBrowser();
				TestBase.getDriver().get(Constants.url);
				CommonUtils.getInstance().initWebElements();
				
		
		} catch (Exception e) {
			System.out.println("e.printStackTrace()");
		}

	}
	
	@Before("not @LoginPage")
	public void initDriver2(Scenario scenario) {

		try {
				scenarioName = scenario.getName();
			
				CommonUtils.getInstance().readConfig();
				LOG.info("Launching Browser");
				TestBase.launchBrowser();
				TestBase.getDriver().get(Constants.url);
				CommonUtils.getInstance().initWebElements();
				LoginPage.getInstance().doLogin(Constants.username, Constants.password);
				
		
		} catch (Exception e) {
			System.out.println("e.printStackTrace()");
		}

	}

	public static String getScenarioName() {
		return scenarioName;
	}

	@After
	public void tearDown() {
		TestBase.getDriver().quit();
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
		byte[] screenshot =	((TakesScreenshot)TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "error screen");
		}
	}
	

}
