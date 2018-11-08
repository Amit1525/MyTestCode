package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;

	/*@BeforeMethod
	@Test
	@AfterMethod*/

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.init_driver();
		prop = basePage.init_properties();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);  //created object of the LoginPage class to call methods of that class
	}

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.verifyForgotMyPasswordLink());
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void checkIfLoginIsSuccessfulTest() {
		loginTest();
		Assert.assertTrue(loginPage.verifyIfLoginIsSuccessful());
	}
	
	@Test(priority=5)
	public void verifyRememberLinkTest() {
		Assert.assertTrue(loginPage.verifyRememberLink());
	}
	
	@Test(priority=6)
	public void verifyGoogleSignInLinkTest() {
		Assert.assertTrue(loginPage.verifyGoogleSignInLink());
	}
	
	@Test(priority=7)
	public void verifyLoginWithSSOLinkTest() {
		Assert.assertTrue(loginPage.verifyLoginWithSSOLink());
	}
	
	@Test(priority=8)
	public void verifyfooterAllRightsTextTest() {
		Assert.assertTrue(loginPage.verifyfooterAllRightsText());
	}

	@Test(priority=9)
	public void verifyfooterPrivacyPolicyLinkTest() {
		Assert.assertTrue(loginPage.verifyfooterPrivacyPolicyLink());
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
