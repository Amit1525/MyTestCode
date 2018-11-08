package com.qa.hubspot.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/amitmahale/eclipse-workspace/HubSpotPOM/src/main/resources/chromedriver-2");
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.findElement(By.id("username")).sendKeys("amit.automation50@gmail.com");
		driver.findElement(By.xpath("password")).sendKeys("Amit@1234");
		driver.findElement(By.id("loginBtn")).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]")).click();
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("(//a[@id='nav-secondary-contacts'])[1]"));
		action.moveToElement(target).build().perform();
		
		
		
	}

}
