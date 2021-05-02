package com.qa.crm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.page.HomePage;
import com.qa.crm.page.LoginPage;

import com.qa.crm.util.AppConstants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	
	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browsername = prop.getProperty("browser");
		driver = basePage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		
		homePage = new HomePage(driver);
		
	}
	@Test(priority =1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
		
		
	}
	@Test(priority = 2)
	public void verifyLoginLinkDisplayedTest() {
		Assert.assertTrue(homePage.checkLoginLinkDisplayed());
	}
	@Test(priority = 3, dependsOnMethods= "verifyLoginLinkDisplayedTest")
	public void clickLoginBtnTest() {
		LoginPage loginPage = homePage.clickLoginBtn();
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
