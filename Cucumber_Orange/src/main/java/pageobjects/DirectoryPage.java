package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {

	private static DirectoryPage directoryPage;

	// Singleton Pattern
	private DirectoryPage() {
		// TODO Auto-generated constructor stub
	}

	public static DirectoryPage getInstance() {

		if (directoryPage == null) {
			directoryPage = new DirectoryPage();
		}
		return directoryPage;
	}
	
	@FindBy(id="searchDirectory_job_title") private WebElement jobTitleSrchBox;
	@FindBy(id="searchDirectory_location") private WebElement locationSrchBox;
	@FindBy(id="searchDirectory_emp_name_empName") private WebElement NameSrchTxtBox;
	@FindBy(id="searchBtn") private WebElement srchBtn;
	@FindBy(id="resetBtn") private WebElement resetBtn;
	
}
