package com.qa.crm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver =driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
	}
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
		
	}
	public void waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/*
	 * This method is used to get the page title
	 */
	public String dogetPageTitle() {
		try {
			return driver.getTitle();
		}catch(Exception e){
			System.out.println("Some exception got occured whole creating the web element...");
			
		}
		return null;
	}
	/*
	 * this method is used to create web element on the basis of By locator
	 * @param locator
	 * @return
	 */
	
	public WebElement dogetElement(By locator) {
		WebElement element = null;
		try {
		 element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("Some exception occured while creating the web element...");
			
		}
		return element;
				
	}
	public boolean doIsDisplayed(By locator) {
		try {
			return dogetElement(locator).isDisplayed();
		}catch(Exception e) {
			System.out.println("Some exception occured while checking the element is displayed");
		}
		return false;
		
	}
	public void doClick(By locator) {
		dogetElement(locator).click();
		
	}
	public void doSentKeys(By locator, String value) {
		try {
			WebElement ele = dogetElement(locator);
			ele.clear();
			ele.sendKeys(value);
		}catch(Exception e) {
			System.out.println("Some exception occured while entering the value in the fiels.....");
		}
		
	
	}
	

}
