package com.qa.crm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.ElementUtil;

public class ContactPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	//By locator
	By contacts = By.xpath("//div[@class='ui header item mb5 light-black'");
	
	//constructor
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	/**********Actions*****/
	 
	
	//Header Text
	public String geContactPageHeader() {
		return elementUtil.doGetText(contacts);
	}

}
