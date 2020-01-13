package com.offbd.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.offbd.qa.base.TestBase;
import com.offbd.qa.util.TestUtil;

public class AddOfferPage extends TestBase{
	@FindBy(className="header_text")
	WebElement headerText;
	@FindBy(className="category_select_box")
	WebElement selectCategory;
	@FindBy(className="product_name")
	WebElement productName;
	@FindBy(className="price")
	WebElement orgPrice;
	@FindBy(className="from_value")
	WebElement discount;
	
	public AddOfferPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String headerTextOfferPage() {
		String pageTitle = headerText.getText();
		return pageTitle;
	}
	
	public AddOfferPage selectCategoryText() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_TIOMOUT, TimeUnit.SECONDS);
		Select select = new Select(selectCategory);
		select.selectByVisibleText("Fashion House");
		return new AddOfferPage();
	}
	
	public void productTitel(String title, String oprice, String dprice) {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_TIOMOUT, TimeUnit.SECONDS);
		productName.sendKeys(title);
		orgPrice.sendKeys(oprice);
		discount.sendKeys(dprice);
		
	}
	
	public AddOfferPage productPrice(String oprice) {
		orgPrice.sendKeys(oprice);
		return new AddOfferPage();
	}
	
	public AddOfferPage productDiscount(String dprice) {
		discount.sendKeys(dprice);
		return new AddOfferPage();
	}
	
	
	
	

}
