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

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browsername = prop.getProperty("browser");
		driver = basePage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		
		homePage = new HomePage(driver);
		loginPage = homePage.clickLoginBtn();
		
	}
	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
