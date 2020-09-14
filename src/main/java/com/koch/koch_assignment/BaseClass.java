package com.koch.koch_assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;





public class BaseClass 
{
	public WebDriver driver;
	
	@BeforeSuite
	@Parameters("browserType")
	public void setup(@Optional("chrome") String browser) throws Exception{
	//public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+ "/geckodriver");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver");
			
			//create chrome instance
			driver = new ChromeDriver();
			
			//Maximize chrome browser 
			driver.manage().window().fullscreen();
		}
		
		else{	
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	public WebDriver getDriver() {
//        return this.driver;
//    }
//	
}

