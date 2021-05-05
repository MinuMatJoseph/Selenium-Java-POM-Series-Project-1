package com.qa.crm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.AppConstants;
import com.qa.crm.util.ElementUtil;


public class CrmFreePage extends BasePage{


WebDriver driver;
ElementUtil elementUtil;

public CrmFreePage(WebDriver driver) {
	this.driver = driver;
	elementUtil = new ElementUtil(driver);
}
 
//By locators
By logIn = By.xpath("//a[contains(@class,'btn-rect btn-icon')]");
By signUp = By.xpath("//a[contains(@class, 'btn-border' )]");

/***********page actions***********/

//Get title of the page
public String getHomePageTitle() {
	elementUtil.waitForTitlePresent(AppConstants.CRMFREE_PAGE_TITLE);
	String title = elementUtil.dogetPageTitle();
	return title;
}

//check login link is displayed
public boolean checkLoginLinkDisplayed() {
	elementUtil.waitForElementVisible(logIn);
	return elementUtil.doIsDisplayed(logIn);
	
}
public LoginPage clickLoginBtn() {
	elementUtil.waitForElementPresent(logIn);
	elementUtil.doClick(logIn);
	return new LoginPage(driver); 
	
}
}