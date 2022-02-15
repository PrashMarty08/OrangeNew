package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import hooks.Hooks;
import pageobjects.DashboardPage;
import pageobjects.DirectoryPage;
import pageobjects.LoginPage;
import pageobjects.MyInfoPage;
import testbase.TestBase;

public class CommonUtils {

	public static Properties prop;
	private static CommonUtils commonUtils = null;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (commonUtils == null) {
			commonUtils = new CommonUtils();
		}
		return commonUtils;
	}

	public void readConfig() {
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constants.url = prop.getProperty("url");
		Constants.browser = prop.getProperty("browser");
		Constants.username = prop.getProperty("username");
		Constants.password = prop.getProperty("password");
	}

	public void initWebElements() {
		PageFactory.initElements(TestBase.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(TestBase.getDriver(), DashboardPage.getInstance());
		PageFactory.initElements(TestBase.getDriver(), DirectoryPage.getInstance());
		PageFactory.initElements(TestBase.getDriver(), MyInfoPage.getInstance());
	}

	public void takeScreenShot() {
		File screenshot = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\Failed Scenarios\\" + Hooks.getScenarioName() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)TestBase.getDriver());
		js.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}

}
