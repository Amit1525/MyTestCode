package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	//HomePage homepage = new HomePage();
	
	@FindBy(xpath = "(//a[@id='nav-primary-contacts-branch' and @class='primary-link'])[1]")
	WebElement contactsHomePageLink;

	@FindBy(xpath = "//i18n-string[text()='Getting started with HubSpot']")
	WebElement homePageHeader;

	@FindBy(xpath = "//span[@class='account-name ']")
	WebElement accountName;
	

	public HomePage(WebDriver driver) {  //Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageHeader() {
		return homePageHeader.getText();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyLoggedAccountName() {
		return accountName.getText();
	}
	
	public ContactsPage clickOnContactsLinkonHomePage() throws Exception {
		Thread.sleep(1000);
		contactsHomePageLink.click();
		
		return new ContactsPage(driver);
	}
	
	

}
