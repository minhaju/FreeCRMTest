package com.offbd.qa.testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offbd.qa.base.TestBase;
import com.offbd.qa.pages.LoginPage;
import com.offbd.qa.pages.ProfilePage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	ProfilePage profilePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =new LoginPage();
	}
	
	@Test(priority=1)
	public void pageTitleOfSite() {
		String title = loginPage.validLoginPageTitle();
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void userLogin() {
		loginPage.clickLogin();
		profilePage= loginPage.loginOnPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public static void browserClose() {		
		driver.quit();
	}
}
