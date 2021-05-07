package com.qa.crm.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	WebDriver driver;
	public JavaScriptUtil(WebDriver driver){
		this.driver = driver;
	}
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i =0; i < 20; i++) {
			changeColor("rgb(0,200,0)",element); //1
			changeColor(bgcolor, element); //2
		}
		
	}
	
	private  void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+ color +"'", element);
		
		try {
			Thread.sleep(20);
			
		}catch(InterruptedException e) {
			
		}
		
	}
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	
	public  void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeAsyncScript("alert('" +message +"')");
	}
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("argument[0].click();", element);
		
	}
	public void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	public String getTitleByJS() {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.title;").toString();
		return pageText;
	}
	public String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	public void scrollPageDown() {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoVierw(true);", element);
		
	}
	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}
	public void sendKeysUsingJSWithId(String id, String value) {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("document.getElementId('"+ id +"').value ='" + value + "'");
		
	}
	public void sendKeysJSWithName( String name, String value) {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("document.getElementByName('" + name +"').value='"+ value +"' ");
		
	}

}