package com.offbd.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.offbd.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory OR
	@FindBy(linkText="Login")
	WebElement Login;
	@FindBy(className="email")
	WebElement Email;
	@FindBy(className="password")
	WebElement Password;
	@FindBy(xpath="//*[@id=\"middleBody\"]/div/form/div[3]/button")
	WebElement Submit;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validLoginPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage clickLogin() {
		Login.click();
		return new LoginPage();
	}
	public LoginPage clickLogin2() {
		Login.click();
		return new LoginPage();
	}
	
	public ProfilePage loginOnPage(String emial, String pass) {
		Email.sendKeys(emial);
		Password.sendKeys(pass);
		Submit.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return new ProfilePage();
	}
	
}
