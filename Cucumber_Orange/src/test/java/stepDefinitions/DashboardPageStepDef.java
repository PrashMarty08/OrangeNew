package stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.DashboardPage;
import testbase.TestBase;

public class DashboardPageStepDef {
	
	private static final Logger LOG = LogManager.getLogger(DashboardPageStepDef.class);

	@Given("User is on the Dashboard Page")
	public void user_is_on_the_dashboard_page() {
		Assert.assertTrue(TestBase.getDriver().getCurrentUrl().contains("dashboard"));

		LOG.info("Successfully Logged In and in Dashboard Page");
	}

	@When("User clicks on the Directory menu")
	public void user_clicks_on_the_directory_menu() {
		DashboardPage.getInstance().clickOnDirectoryMenu();
		LOG.info("Successfully Clicked the Directory Menu");
	}

	@Then("Directory Page should be displayed")
	public void directory_page_should_be_displayed() {
		Assert.assertTrue(TestBase.getDriver().getCurrentUrl().contains("directory"));
		LOG.info("Successfully Navigated to Directory Page");
	}
	

	@Then("Quick Launch section should be displayed")
	public void quick_launch_section_should_be_displayed() {
		String quickLaunchText = DashboardPage.getInstance().getQuickLaunchHeader().getText();
		Assert.assertEquals("Quick Launch", quickLaunchText);
		LOG.info("Quick Launch section is available");
	}
	@Then("Quick Launch section should have the below links")
	public void quick_launch_section_should_have_the_below_links(io.cucumber.datatable.DataTable dataTable) {

		List<String> actualList = dataTable.asList();
		boolean result = actualList.equals(DashboardPage.getQuickLaunchLinks());
		Assert.assertTrue(result);
		LOG.info("All the expected Quick Launch Links are available");
	}



	
}
