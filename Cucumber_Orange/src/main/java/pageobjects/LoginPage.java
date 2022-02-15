package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage {

	//Singleton Pattern
	private static LoginPage loginInstance;

	private LoginPage() {
	}

	public static LoginPage getInstance() {

		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
	}

	@FindBy(id = "txtUsername")
	private WebElement userNameTxtBox;
	@FindBy(id = "txtPassword")
	private WebElement passwordTxtBox;
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	@FindBy(partialLinkText = "Forgot your password")
	private WebElement forgotUrPswdLink;
	@FindBy(xpath = "//input[@id='btnLogin']/following-sibling::span")
	private WebElement loginErrorMsg;
	@FindBy(xpath = "//a[@href='http://www.facebook.com/OrangeHRM']")
	private WebElement fbIcon;
	@FindBy(partialLinkText = "OrangeHRM, Inc")
	private WebElement footerLink;
	@FindBy(xpath = "//div[@id='footer']//div[text()]")
	private WebElement footerContent;
	@FindBy(xpath = "//a")
	private List<WebElement> links;
	
	public void doLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		loginBtn.click();
	}

	//Getters
	public WebElement getUserNameTxtBox() {
		return userNameTxtBox;
	}

	public WebElement getPasswordTxtBox() {
		return passwordTxtBox;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getForgotUrPswdLink() {
		return forgotUrPswdLink;
	}
	
	public WebElement getLoginErrorMsg() {
		return loginErrorMsg;
	}

	//page functions
	public void setLoginErrorMsg(WebElement loginErrorMsg) {
		this.loginErrorMsg = loginErrorMsg;
	}

	public void enterUsername(String username) {
		userNameTxtBox.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickFbIcon() {
		fbIcon.click();
	}
	
	public boolean isFooterLinkDisplayed() {
		return footerLink.isDisplayed();
	}
	
	public String getFooterLinkText() {
		return footerLink.getText();
	}
	
	public String getCopyrightText() {
		String copyrightText = null;
		String newContent = footerContent.getText().replace(getFooterLinkText(), "");
		String [] array = newContent.split("\\.|\n");
		for (String string : array) {
			if(string.contains("©"))
				copyrightText = string.trim();
		}
		return copyrightText;
	}
	
	public void getAllLinks() {
		for (WebElement webElement : links) {
			System.out.println(webElement.getText());
		}
	}
	
}
