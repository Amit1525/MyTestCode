package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;

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
		Thread.sleep(2000);
		
	}
	
	@Test(priority=1)
	public void getHomePageHeader() {
		String header = homePage.getHomePageHeader();
		System.out.println("Home Page header is: "+ header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=2)
	public void getHomepageTitleTest() {
		String title = homePage.getHomePageTitle();
		title.contains("HubSpot");
		Assert.assertTrue(title.contains("HubSpot"));
		System.out.println("Home Page title is: "+ title);
		//Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=3)
	public void verifyLoggedAccountNameTest() {
		String accountName = homePage.verifyLoggedAccountName();
		System.out.println("Logged In Account Name is: "+ accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='account-name ']")).click();
		driver.findElement(By.xpath("//a[@id='signout']")).click();
		driver.quit();
	}

}
