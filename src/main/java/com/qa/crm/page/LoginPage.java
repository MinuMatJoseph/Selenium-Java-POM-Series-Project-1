package com.qa.crm.page;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.AppConstants;
import com.qa.crm.util.ElementUtil;




public class LoginPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//By locators
	
	/***********page actions***********/
	
	public String getLoginPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
		return elementUtil.dogetPageTitle();
	}

}
