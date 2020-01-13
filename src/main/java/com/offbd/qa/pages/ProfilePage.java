package com.offbd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.offbd.qa.base.TestBase;

public class ProfilePage extends TestBase {
	@FindBy(className="header_text")
	WebElement headerText;
	@FindBy(className="myofferList")
	WebElement myOffers;
	@FindBy(className="addOffer")
	WebElement addOffers;
	@FindBy(className="addShowrrom")
	WebElement addCntact;
	
	public ProfilePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String headerTitle() {
		String headerTitleText = headerText.getText();
		return headerTitleText;
	}
	
	public String verifyProfilePageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public MyOfferPage clickOnMyOfferLink() {
		myOffers.click();
		return new MyOfferPage();
	}
	
	public AddOfferPage clickOnAddOfferLink() {
		addOffers.click();
		return new AddOfferPage();
	}
	public AddContactPage clickOnAddInformationLink() {
		addCntact.click();
		return new AddContactPage();
	}
}
