package com.qa.crm.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.AppConstants;
import com.qa.crm.util.Credentials;
import com.qa.crm.util.ElementUtil;

public class LoginPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//By locators
	By email = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name='password']");
	By login =By.xpath("//div[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	/***********page actions***********/
	
	public String getLoginPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
		return elementUtil.dogetPageTitle();
	}
	public HomePage getLogin(Credentials userCred) {
		elementUtil.waitForElementPresent(email);
		elementUtil.doSentKeys(email, userCred.getAppUsername());
		elementUtil.doSentKeys(password, userCred.getAppPassword());
		elementUtil.doClick(login);
		return new HomePage(driver);
	}

}
