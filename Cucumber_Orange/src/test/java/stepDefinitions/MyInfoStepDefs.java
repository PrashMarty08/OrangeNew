package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.MyInfoPage;
import testbase.TestBase;

public class MyInfoStepDefs {

	private static final Logger LOG = LogManager.getLogger(MyInfoStepDefs.class);
	
	@Given("User in on Dashboard Page")
	public void user_in_on_dashboard_page() {
		Assert.assertTrue(TestBase.getDriver().getCurrentUrl().contains("dashboard"));

		LOG.info("Successfully Logged In and in Dashboard Page");
	}
	@Then("User clicks on My Info page menu")
	public void user_clicks_on_my_info_page_menu() {
		MyInfoPage.getInstance().clickMyInfoMenu();
	}
	@Given("User is on the MyInfo page")
	public void user_is_on_the_my_info_page() {
		Assert.assertTrue(TestBase.getDriver().getCurrentUrl().contains("MyDetails"));

		LOG.info("Successfully Logged In and in My Info Page");
	}
	@When("User clicks on Memberships Menu")
	public void user_clicks_on_memberships_menu() {
		MyInfoPage.getInstance().clickMembershipMenu();
	}
	@When("User clicks on Add Membership button")
	public void user_clicks_on_add_membership_button() {
		MyInfoPage.getInstance().clickAddMembershipBtn();
	}

	@When("User selects the Membership {string}")
	public void user_selects_the_membership(String string) {
	    MyInfoPage.getInstance().selectMemebership("Visible Text", string, 0);
	    
	}
	
	@When("User clicks on Save")
	public void user_clicks_on_save() {
		MyInfoPage.getInstance().clickSaveBtn();
	}
	@Then("Membership should be added")
	public void membership_should_be_added() {
		LOG.info("Saved");
	}

	@When("User clicks on Add Attachments button")
	public void user_clicks_on_add_attachments_button() {
	    MyInfoPage.getInstance().clickAttchBtn();
	}
	@When("user attaches the file")
	public void user_attaches_the_file() {
		MyInfoPage.getInstance().clickChooseFileBtn();
		try {
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\AutoIT\\FileUpload.exe");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@When("user clicks on Upload button")
	public void user_clicks_on_upload_button() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyInfoPage.getInstance().clickUploadAttmntBtn();
	}
	@Then("File should be uploaded successfully")
	public void file_should_be_uploaded_successfully() {
	   boolean test = TestBase.getDriver().findElement(By.id("tblAttachments")).isDisplayed();
	   Assert.assertTrue(test);
	   LOG.info("File Uploaded Successfully");
	   System.out.println("Test");
		//System.out.println("Test");
		System.out.println("Test2");
	}




}
