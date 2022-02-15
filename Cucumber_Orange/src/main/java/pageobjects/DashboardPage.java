package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	private static DashboardPage dashboardPage;

	// Singleton Pattern
	private DashboardPage() {
		// TODO Auto-generated constructor stub
	}

	public static DashboardPage getInstance() {

		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}
	
	@FindBy(id="menu_directory_viewDirectory") private static WebElement directoryMenu;
	@FindBy(xpath="//*[@id='panel_resizable_0_0']/legend") private static WebElement quickLaunchHeader;
	@FindBy(xpath="//span[@class='quickLinkText']")private static List<WebElement> quickLaunchList;
	
	public void clickOnDirectoryMenu() {
		directoryMenu.click();
	}
	
	public static List<String> getQuickLaunchLinks() {
		List<String> linkList = new ArrayList<String>();
		
		for (WebElement webElement : quickLaunchList) {
			String linkText = webElement.getText();
			
			linkList.add(linkText);	
		}
		
		return linkList;
	}
	
	
	
	//getters
	public static WebElement getQuickLaunchHeader() {
		return quickLaunchHeader;
	}
	
	
}
