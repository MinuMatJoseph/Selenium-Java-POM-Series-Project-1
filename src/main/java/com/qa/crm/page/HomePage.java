package com.qa.crm.page;

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
	
	public String getHomePageTitle() {
		
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
//		return elementUtil.dogetPageTitle();
		return jsUtil.getTitleByJS();
		
	}

}
