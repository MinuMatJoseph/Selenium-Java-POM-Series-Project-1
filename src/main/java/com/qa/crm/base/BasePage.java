package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	// initialize the browser
	public WebDriver init_driver(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("forefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class);
			driver = new SafariDriver();
		}
		else {
			System.out.println("Browser name "+ browsername + " not found, please enter correct browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
			
		return driver;
	}
	
	//initialize properties
	public Properties init_properties() {
		prop = new Properties();
		String path = ".\\src\\main\\java\\com\\qa\\crm\\config\\config.properties";
		
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Some issue with config properties.... please correct the config....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
		
	}
	
	

}
