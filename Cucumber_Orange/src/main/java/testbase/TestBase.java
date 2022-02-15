package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {


	private static WebDriver driver = null;

	private static final Logger LOG = org.apache.logging.log4j.LogManager.getLogger(TestBase.class);
	
	public static void launchBrowser() {
		// TODO Auto-generated method stub

		try {

			switch (Constants.browser) {
			case "chrome":
				LOG.info("Selected Browser is Chrome");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			case "internet explorer":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			default:
				break;
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
}
