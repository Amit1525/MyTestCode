package com.qa.hubspot.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.hubspot.util.Constants;


public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver() {
		System.setProperty("webdriver.chrome.driver", "/Users/amitmahale/eclipse-workspace/HubSpotPOM/src/main/resources/chromedriver-2");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		try {
		    //input file - means we will make a connection with a file where our data is present
			FileInputStream ip = new FileInputStream("/Users/amitmahale/eclipse-workspace/HubSpotPOM/src/main/java/com/qa/hubspot/config/config.properties");

			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}


}
