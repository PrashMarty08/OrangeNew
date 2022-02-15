package stepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import testbase.TestBase;
import utilities.CommonUtils;

public class LoginPageStepDef extends TestBase {

	private static final Logger LOG = LogManager.getLogger(LoginPageStepDef.class);

	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
		Assert.assertTrue(TestBase.getDriver().findElement(By.id("txtUsername")).isDisplayed());

		LOG.info("User is on Login Page");
	}

	@When("User enters Username and Password as {string} and {string}")
	public void user_enters_username_and_password_as_and(String userName, String PassWord) {

		try {
			CommonUtils.getInstance().highlightElement(LoginPage.getInstance().getUserNameTxtBox());
			LoginPage.getInstance().enterUsername(userName);
			CommonUtils.getInstance().highlightElement(LoginPage.getInstance().getPasswordTxtBox());
			LoginPage.getInstance().enterPassword(PassWord);

			LOG.info("User has entered the Username and Password");
		} catch (Exception e) {
			LOG.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}

	}

	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {
		CommonUtils.getInstance().highlightElement(LoginPage.getInstance().getLoginBtn());
		LoginPage.getInstance().clickLoginBtn();

		
		LOG.info("User has clicked on the Login Button");
	}

	@Then("User should be able to login to the website")
	public void user_should_be_able_to_login_to_the_website() {

		try {
			CommonUtils.getInstance().highlightElement(TestBase.getDriver().findElement(By.id("welcome")));
			Assert.assertTrue(TestBase.getDriver().findElement(By.id("welcome")).isDisplayed());

			LOG.info("Login is Successful");
		} catch (Exception e) {
			LOG.error(e);
			CommonUtils.getInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		CommonUtils.getInstance().highlightElement(LoginPage.getInstance().getLoginErrorMsg());
		Assert.assertTrue(LoginPage.getInstance().getLoginErrorMsg().isDisplayed());

		
		LOG.info("Error message is displayed");
	}


	@When("User clicks on Facebook link")
	public void user_clicks_on_facebook_link() {
		LoginPage.getInstance().clickFbIcon();
		
		LOG.info("User has clicked on facebook icon");
	}
	
	@Then("Facebook page of the company should be opened")
	public void facebook_page_of_the_company_should_be_opened() {
		Set<String> currentw = TestBase.getDriver().getWindowHandles();
		
		Iterator<String> iter = currentw.iterator();
		
		String parentWindowID = iter.next();
		
		System.out.println("Parent Window ID is: " + parentWindowID);
		
		String childWindowID1 = iter.next();
		
		System.out.println("Child Window ID is: " + childWindowID1);
		
		TestBase.getDriver().switchTo().window(childWindowID1);
		
		System.out.println("Page Title of Child Window: " + TestBase.getDriver().getTitle());
		
		
		Assert.assertTrue(TestBase.getDriver().getCurrentUrl().contains("facebook"));
		
		
		LOG.info("Successfully navigated to Facebook");
	}


	@Then("Link to Orange HRM should be displayed with link text {string}")
	public void link_to_orange_hrm_should_be_displayed_with_link_text(String string) {
		boolean footer = LoginPage.getInstance().isFooterLinkDisplayed();
		Assert.assertTrue(footer);
		
		LOG.info("Footer Link is available");
	}
	
	@Then("copyright message with content {string} should be displayed")
	public void copyright_message_with_content_should_be_displayed(String string) {
		Assert.assertEquals(LoginPage.getInstance().getCopyrightText(),string);
		
		LOG.info("Copyright message matches");
	}
	
	@Then("following message should be displayed {string}")
	public void following_message_should_be_displayed(String string) {

	}
	
	
	@Then("{string} should be displayed")
	public void should_be_displayed(String string) {
		Assert.assertTrue(LoginPage.getInstance().getLoginErrorMsg().isDisplayed());
		Assert.assertEquals(LoginPage.getInstance().getLoginErrorMsg().getText(),string);

		
		LOG.info("Error message is displayed correctly");
	}


	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {

		LoginPage.getInstance().enterUsername(string);

		LoginPage.getInstance().enterPassword(string2);
	}
	




	
	











}
