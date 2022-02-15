package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testbase.TestBase;

public class MyInfoPage {
	
	private static final Logger LOG = LogManager.getLogger(MyInfoPage.class);

	private static MyInfoPage myInfoPage;

	private MyInfoPage() {

	}

	public static MyInfoPage getInstance() {
		if (myInfoPage == null) {
			myInfoPage = new MyInfoPage();
		}

		return myInfoPage;
	}

	@FindBy(partialLinkText = "My Info")
	private WebElement myInfoMenuLink;
	@FindBy(partialLinkText = "Memberships")
	private WebElement membershipMenu;
	@FindBy(id = "btnAddMembershipDetail")
	private WebElement addMembershipBtn;
	@FindBy(id = "membership_membership")
	private WebElement membershipDropdown;
	@FindBy(id="btnSaveMembership")
	private WebElement saveBtn;
	@FindBy(xpath = "//input[@id='btnAddAttachment']")
	private WebElement attachBtn;
	@FindBy(id="btnSaveAttachment")
	private WebElement uploadAttchBtn;
	@FindBy(id="ufile")
	private WebElement chooseFileBtn;

	public void clickMyInfoMenu() {
		myInfoMenuLink.click();
	}
	
	public void clickMembershipMenu() {
		membershipMenu.click();
	}
	
	public void clickAddMembershipBtn() {
		addMembershipBtn.click();
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	public void selectMemebership(String value, String value2, int value3) {
		Select select = new Select(membershipDropdown);
		switch (value) {
		case "Visible Text":
			select.selectByVisibleText(value2);
			break;
		case "Index":
			select.selectByIndex(value3);
		case "Value":
			select.selectByValue(value2);
		default:
			System.out.println("Please select a valid selection method");
			LOG.info("No Valid Selection Method Selected");
			break;
		}
	}
	
	public void clickAttchBtn() {
		attachBtn.click();
	}

	public void clickUploadAttmntBtn() {
		uploadAttchBtn.click();
	}
	
	public void clickChooseFileBtn() {
		Actions actions = new Actions(TestBase.getDriver());
        
		WebElement uploadAttchBtn = chooseFileBtn;
		actions.moveToElement(uploadAttchBtn).click().perform();

	}
}