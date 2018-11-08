package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class ContactsPageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;

	/*@BeforeMethod
	@Test
	@AfterMethod*/

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		driver = basePage.init_driver();
		prop = basePage.init_properties();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);  //created object of the LoginPage class to call methods of that class
		//homePage = new HomePage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);	
		contactsPage = homePage.clickOnContactsLinkonHomePage();
		Thread.sleep(2000);	

	}
	
	@Test(priority=1)
	public void createNewContactTest() throws Exception {
		contactsPage.createNewContact(prop.getProperty("createnewcontactemail"), 
	    prop.getProperty("createnewcontactfirstname"), prop.getProperty("createnewcontactlasttname"));
	}	
	
	@Test(priority=2)
	public void clickOnContactsMenuUnderContactsLinkTest() throws Exception {
		contactsPage.clickOnContactsMenuUnderContactsLink();
	}
	
	@Test(priority=3)
	public void verifyContactsPageHeaderTest() throws Exception {
		String header = contactsPage.verifyContactsPageHeader();
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER);
	}
	
	@Test(priority=4)
	public void deleteContactsTest() throws Exception {
		contactsPage.deleteContacts();
		
		
	}


	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='account-name ']")).click();
		driver.findElement(By.xpath("//a[@id='signout']")).click();
		driver.quit();
	}


}
