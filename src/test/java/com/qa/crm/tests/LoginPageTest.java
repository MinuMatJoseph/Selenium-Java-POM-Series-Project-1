package com.qa.crm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.page.CrmFreePage;
import com.qa.crm.page.LoginPage;
import com.qa.crm.util.AppConstants;
import com.qa.crm.util.Credentials;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	CrmFreePage homePage;
	LoginPage loginPage;
	Credentials userCred;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browsername = prop.getProperty("browser");
		driver = basePage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		
		homePage = new CrmFreePage(driver);
		loginPage = homePage.clickLoginBtn();
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority = 2)
	public void getLogin() {
		loginPage.getLogin(userCred);
		
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.close();
//	}

}
