package com.qa.crm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.page.CrmFreePage;
import com.qa.crm.page.HomePage;
import com.qa.crm.page.LoginPage;
import com.qa.crm.util.AppConstants;
import com.qa.crm.util.Credentials;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	CrmFreePage crmFreePage;
	LoginPage loginPage;
	Credentials userCred;
	HomePage homePage;
	
	
	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		crmFreePage = new CrmFreePage(driver);
		loginPage = crmFreePage.clickLoginBtn();
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.getLogin(userCred);
		
		
		
		
	}
	@Test(priority = 1)
	public void getHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
		
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.close();
//	}
}
