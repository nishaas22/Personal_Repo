package com.koch.koch_assignment;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.koch.koch_assignment.BaseClass;
import com.koch.koch_assignment.Constants.GenericConstants;

import com.koch.koch_assignment.pages.FlightsPage;



public class AirlineFlightsDetailsScenarios extends BaseClass
{

	
	@BeforeTest
	public void launchSite()
	{
		driver.get(GenericConstants.baseUrl);
		
	}
	
	
	//Validating the page by finding the element 
	@Test(priority=1)
    public void validatePage() 
	{
		FlightsPage flightDetails=new FlightsPage(driver);
		boolean elementResult = flightDetails.validateElementPresent();
		//String actualText="Search. Book. Go.";
		Assert.assertTrue(elementResult, "Element not present and fails to validate the page");
	}
	
	
	//Validating search result    
	@Test(priority=2)
    public void validatesearchResult() throws InterruptedException 
    {
		FlightsPage flightDetails=new FlightsPage(driver);
		boolean elementResult =flightDetails.searchFlightAndValidate();
		Assert.assertTrue(elementResult, "Search result for flights for the Pune to Hyderabad (17/09 -24/10) is not displayed");
    }
	
	 	
	
	//Select all three filters
	@Test (priority=4)                            
    public void validateFilterOptions() throws InterruptedException 
    {
		FlightsPage flightDetails=new FlightsPage(driver);
		String selectedFilterValue=flightDetails.filter();
		assertTrue(selectedFilterValue.contains(GenericConstants.filterSelectedInfo), "All the three filters not selected successfully");
		
    }
	
	
	//List of airlines details  
	@Test (priority=3)                            
    public void validateAirlineDetails() throws InterruptedException 
    {
		FlightsPage flightDetails=new FlightsPage(driver);
		boolean listOfAirline= flightDetails.listOfAirlinepriceLessFiveHund();
		Assert.assertTrue(listOfAirline, "Search result for flights for the Pune to Hyderabad (17/09 -24/10) is not displayed");
    }
	
	
	
	
	@AfterTest(description="Close all the browser windows")
	public void quit()
	{
		driver.quit();
	}
	
}
	


