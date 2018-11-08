package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	//1. Define Page Factory of the page elements / Object Repository
	//   1.1 Initialize driver - Create a Constructor of Page Class and Initialize Page Element (with Driver) with PageFactory Class
	//2. Create all the necessary Actions/Methods

	@FindBy(id = "username")
	WebElement loginName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id="loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath = "//i18n-string[text()='Getting started with HubSpot']")
	WebElement salesDashboardText;

	@FindBy(xpath = "//a/i18n-string[contains(text(),'Forgot my password')]")
	WebElement forgotMyPwdLink;
	
	@FindBy(xpath = "//span[@class='private-checkbox__text']/i18n-string")
	WebElement rememberMeLink;

	@FindBy(xpath = "//span[@class='buttonText']")
	WebElement goolgeSignInLink;
	
	@FindBy(xpath = "//button[@id='ssoBtn']/i18n-string")
	WebElement loginWithSSO;
	
	@FindBy(xpath = "//footer[@class='copyright']/i18n-string")
	WebElement footerAllRights; 
	
	@FindBy(xpath = "//a[@class='private-link uiLinkWithoutUnderline uiLinkDark']/i18n-string")
	WebElement footerPrivacyPolicy;
	
	public LoginPage(WebDriver driver) {  //Define Constructor of Page Class
		this.driver = driver;
		PageFactory.initElements(driver, this);  //this means current class Object, we can also write - LoginPage.class	
	}

	public String getLoginPageTitle() { 
		return driver.getTitle();
	}

	public boolean verifyForgotMyPasswordLink() {
		return forgotMyPwdLink.isDisplayed();
	}

	public HomePage doLogin(String username, String pwd) {
		loginName.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
	}
	
	public boolean verifyIfLoginIsSuccessful() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(salesDashboardText));
		return salesDashboardText.isDisplayed();
	}
	
	public boolean verifyRememberLink() {
		return rememberMeLink.isDisplayed();
	}
	
	public boolean verifyGoogleSignInLink() {
		return goolgeSignInLink.isDisplayed();
	}
	
	public boolean verifyLoginWithSSOLink() {
		return loginWithSSO.isDisplayed();
	}

	public boolean verifyfooterAllRightsText() {
		return footerAllRights.isDisplayed();
	}
	
	public boolean verifyfooterPrivacyPolicyLink() {
		return footerPrivacyPolicy.isDisplayed();
	}
	
}
