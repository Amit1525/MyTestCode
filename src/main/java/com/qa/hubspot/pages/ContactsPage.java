package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends BasePage {

	public static WebDriverWait wait;

	@FindBy(xpath = "(//a[@id='nav-primary-contacts-branch'])[1]") //(//a[@id='nav-primary-contacts-branch'])[1]
	WebElement contactsHomePageLink;

	@FindBy(xpath = "(//a[@id='nav-secondary-contacts'])[1]")
	WebElement contactsMenuUnderContactsLink;

	@FindBy(xpath = "//i18n-string[text()='Contacts']")
	WebElement ContactsHomePageHeader;

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactLink;

	@FindBy(xpath = "//h3[text()='Create contact']")
	WebElement createContactH3Tag;

	@FindBy(xpath = "//input[@id='uid-ctrl-1']")
	WebElement createContactEmail;

	@FindBy(xpath = "//input[@id='uid-ctrl-2']")
	WebElement createContactFirstName;

	@FindBy(xpath = "//input[@id='uid-ctrl-3']")
	WebElement createContactLastName;

	@FindBy(xpath = "//ul[@class='uiList private-list--inline private-list--unstyled display-flex flex-wrap']/li[1]")
	WebElement createContactAfterFillingDetailsButton;

	@FindBy(xpath= "(//span[text()='Cancel'])[2]")   
	WebElement CreateContactH3TagCancel;
	
	@FindBy(xpath = "//th[@class='checkbox-cell p-x-3']")
	WebElement selectAllContactCheckBox;
	
	@FindBy(xpath = "//span[text()='Delete']")
	WebElement deleteContactsBtn; 
	
	@FindBy(xpath = "//textarea[@class='form-control private-form__control private-text-area private-match-text__input private-match-text__input--xxl private-text-area--no-resize']") 
	WebElement numberOfContactsforDeletion;
	
	
	@FindBy(xpath = "(//span[text()='Delete'])[2]")
	WebElement deleteContactRedButton;
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnContactsMenuUnderContactsLink() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(contactsMenuUnderContactsLink).build().perform();
		Thread.sleep(1000);
		contactsMenuUnderContactsLink.click();////*[@id=\"nav-secondary-contacts\"]
		//action.moveToElement(target).build().perform();
		//action.doubleClick(target).build().perform();
	
	}

	public String verifyContactsPageHeader() throws Exception {
		clickOnContactsMenuUnderContactsLink();
		//Thread.sleep(2000);
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ContactsHomePageHeader));
		return ContactsHomePageHeader.getText();	
	}


	public void createNewContact(String createnewcontactemail, String createnewcontactfirstname, String createnewcontactlasttname) throws Exception {
		clickOnContactsMenuUnderContactsLink();
		wait  = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ContactsHomePageHeader));
		//Thread.sleep(1000);
		createContactLink.click();
		Thread.sleep(2000);
		createContactEmail.sendKeys(createnewcontactemail);
		Thread.sleep(2000);
		createContactFirstName.sendKeys(createnewcontactfirstname);
		createContactLastName.sendKeys(createnewcontactlasttname);
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(createContactAfterFillingDetailsButton));
		createContactAfterFillingDetailsButton.click();

	}
	
	public void deleteContacts() throws Exception {
		clickOnContactsMenuUnderContactsLink();
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(selectAllContactCheckBox));
		selectAllContactCheckBox.click();
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(deleteContactsBtn));
		deleteContactsBtn.click();
		
		numberOfContactsforDeletion.sendKeys("10");
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(deleteContactRedButton));
		deleteContactRedButton.click();
		
	}



}
