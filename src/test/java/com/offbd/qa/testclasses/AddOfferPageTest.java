package com.offbd.qa.testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.offbd.qa.base.TestBase;
import com.offbd.qa.pages.AddContactPage;
import com.offbd.qa.pages.AddOfferPage;
import com.offbd.qa.pages.LoginPage;
import com.offbd.qa.pages.MyOfferPage;
import com.offbd.qa.pages.ProfilePage;
import com.offbd.qa.util.TestUtil;

public class AddOfferPageTest extends TestBase{
	LoginPage loginPage;
	ProfilePage profilePage;
	AddOfferPage addOfferPage;
	
	String sheetNameTest = "offers";

	public AddOfferPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =new LoginPage();
		loginPage.clickLogin();
		addOfferPage = new AddOfferPage();
		profilePage= loginPage.loginOnPage(prop.getProperty("username"), prop.getProperty("password"));	
		addOfferPage= profilePage.clickOnAddOfferLink();
	}
	
	@Test(priority=1)
	public void verifyHeaderTextTest() {
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		String headerTitle = addOfferPage.headerTextOfferPage();
		System.out.println(headerTitle);
	}
	
	@DataProvider
	public Object[][] getOffbdTestData() throws EncryptedDocumentException, IOException {
		return TestUtil.getTestData(sheetNameTest);
	}
	
	@Test(priority=2, dataProvider="getOffbdTestData")
	public void addNewOffer(String title, String price, String discount) throws InterruptedException {
		addOfferPage.selectCategoryText();
		addOfferPage .productTitel(title, price, discount);
		//.productTitel("Mobile Offer", "500", "50");	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
