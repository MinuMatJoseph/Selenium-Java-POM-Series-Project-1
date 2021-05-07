package com.qa.crm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.AppConstants;
import com.qa.crm.util.ElementUtil;
import com.qa.crm.util.JavaScriptUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		
	}
	//By locators
	By settingMenu = By.cssSelector("div.ui.basic.button.floating.item.dropdown");
	By logout = By.xpath("//span[@class='text' and text() ='Log Out']");
	
	By userIconContacts = By.cssSelector("i.users.icon");	
	By userContact = By.xpath("//span[text()='Contacts']");
	
	public String getHomePageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
//		return elementUtil.dogetPageTitle();
		return jsUtil.getTitleByJS();
		
	}
	public ContactPage homeMenuItemUser() {
		elementUtil.waitForElementPresent(settingMenu);
		elementUtil.doMouseMove(userIconContacts);
		elementUtil.doClick(userContact);
		return new ContactPage(driver);
		
	}
	public void logOutClick() {
		elementUtil.waitForElementVisible(settingMenu);
		elementUtil.doClick(settingMenu);
		elementUtil.doClick(logout);
		
	}

}
