package com.offbd.qa.testclasses;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.offbd.qa.base.TestBase;
import com.offbd.qa.pages.AddContactPage;
import com.offbd.qa.pages.AddOfferPage;
import com.offbd.qa.pages.LoginPage;
import com.offbd.qa.pages.MyOfferPage;
import com.offbd.qa.pages.ProfilePage;

public class ProfilePageTestCases extends TestBase{
	LoginPage loginPage;
	ProfilePage profilePage;
	AddOfferPage addOfferPage;
	MyOfferPage myOfferPage;
	AddContactPage addContactPage;
	
	public ProfilePageTestCases(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =new LoginPage();
		loginPage.clickLogin();
		addOfferPage = new AddOfferPage();
		myOfferPage= new MyOfferPage();
		addContactPage = new AddContactPage();
		profilePage= loginPage.loginOnPage(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void verifyHeaderTextTest() {
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		String headerTitle = profilePage.headerTitle();
		System.out.println(headerTitle);
	}
	
	@Test(priority=2)
	public void verifyProfilePageTitleTest() {
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		String pageTitle= profilePage.verifyProfilePageTitle();
		System.out.println(pageTitle);
	}
	
	@Test(priority=3)
	public void verifyMyOfferLink(){
		myOfferPage= profilePage.clickOnMyOfferLink();
	}
	
	@Test(priority=4)
	public void verifyAddOfferLink(){
		addOfferPage= profilePage.clickOnAddOfferLink();
	}
	
	@Test(priority=5)
	public void verifyAddInformationLink(){
		addContactPage= profilePage.clickOnAddInformationLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
