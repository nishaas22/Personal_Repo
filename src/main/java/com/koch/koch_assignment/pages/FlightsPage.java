package com.koch.koch_assignment.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.koch.koch_assignment.BaseClass;
import com.koch.koch_assignment.Constants.GenericConstants;

public class FlightsPage 

{
	WebDriver driver;
   public FlightsPage (WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(xpath = "//img[@id='ixiLogoImg']")
	private WebElement ixigo_text_in_Page;
	
	@FindBy(xpath = "//div[@title='Search. Book. Go.']")
	private WebElement validateText;
	
	
	@FindBy(xpath = "//div[@class='passanger-class-input u-pos-rel']//input[@class='c-input u-v-align-middle']")
	public WebElement travelersTab; 
	
	@FindBy(xpath = "//div[@class='u-box passanger-class-list flex-container']//div[@class='u-box-result'][1]//div[@class='number-counter'][1]//div[@class='u-ib items u-v-align-middle']//span[2]")
	public WebElement travelersCount;
	
	@FindBy(xpath = "//div[@class='form-fields']//div[@class='search u-ib u-v-align-bottom']//button")
	public WebElement search;
	
	
	@FindBy(xpath="//div[text()='From']//following-sibling::input")
	public WebElement fromPlace;
	
	@FindBy(xpath="//div[text()='To']//following-sibling::input")
	public WebElement toPlace;
	
	@FindBy(xpath="//div[@class='autocompleter-results u-box autocompleter-results-caret']//div[@class= 'city']")
	public List <WebElement> cityNamesAutoSuggest;
	
	
	@FindBy(xpath="//div[text()='Departure']//following-sibling::input")
	public WebElement depature;
	
	
	@FindBy(xpath = "//div[@class ='rd-month'][1]//tbody[@class='rd-days-body']//tr[3]//td[5]//div[text()='17']//following-sibling::div")
	private WebElement departureDateSelection;
	
	
	@FindBy(xpath = "//div[text()='Return']//following-sibling::input")
	public WebElement returnslection;
	
	
	@FindBy (xpath="//div[@class='rd-date']//div[@class='rd-month'][1]//table[@class='rd-days']//tbody[@class='rd-days-body']//tr[4]//td[7]//div[text()='24']//following-sibling::div")
	public WebElement returnDateSelection;
	
	
	@FindBy(xpath = "/div[@class='rd-date']//div[@class='rd-month'][2]")
	public WebElement returnwindow;
	
	
	@FindBy(xpath ="//div[contains(@class, 'close-btn')]")
	public WebElement close;
	
	
	@FindBy(xpath ="//div[@class='rd-container flight-ret-cal extra-bottom rd-container-attachment']//button[@class='ixi-icon-arrow rd-next']")
	public WebElement forwardArrow;
	
	
	@FindBy(xpath="//span[text()='17 Sep, Thu']")
	public WebElement tipStartDate;
	
	
	@FindBy(xpath="//span[text()='24 Oct, Sat']")
	public WebElement tipReturnDate;
	
	
	@FindBy(xpath="//button[text()='Book']")
	public WebElement bookField;
	
	@FindBy(xpath="//div[@class='result-wrpr']")
	public WebElement listOfAirline;
	
	@FindBy(xpath="//div[@class='fltr-cntnt']//div[@class='stops']//div[@class='checkbox-list-item '][1]//span[contains(@class, 'checkbox-button')]")
	public WebElement filterNonStop;
	
	@FindBy(xpath="//div[@class='result-wrpr']//div[@class='result-col outr']//div[@class='result-col-inner']//div[contains(@class,'c-flight-listing-split')]")
	public List <WebElement> airlineResultPuneToHyd;

	
	@FindBy(xpath="//div[@class='result-wrpr']//div[@class='result-col outr']//div[@class='result-col-inner']//div[contains(@class,'c-flight-listing-split')]//div[@class='summary-section']//div[@class='c-price-display u-text-ellipsis ']//span[2]")
	public List<WebElement> airlinePriceDetails;
	
	
	@FindBy(xpath="//div[@class='fltr-col-2 u-ib']//div[@class='fltr tmng'][1]//div[@class='fltr-cntnt']//div[@class='tmng-btn-cntnr']//div[@class='tmng-btn'][1]//button[1]")
	public WebElement filterDepature;
	
	
	@FindBy(xpath="//div[@class='fltr-col-3 u-ib']//div[@class='fltr u-pos-rel arln']//div[@class='fltr-cntnt u-cstm-scroll']//span[@class='checkbox-list']//div[@class='checkbox-list-item '][1]")
	private WebElement filterAirline;
	
	
	@FindBy(xpath="//div[@class='cta']//button[@class='c-btn u-link enabled']//div")
	private WebElement resetButton;
	
	
	@FindBy(xpath="//div[@class='active-filter']")
	private WebElement slectedFilterInfo;


	
	
	/* Get the text "Search. Book. Go." in the launch page and return the Text
	 * */
	public String validateTextInPage()
	{
		String validationtext=validateText.getAttribute("innerText");
		System.out.println(validationtext);
		return validationtext;
	}
	
	/*
	 * Validate the page by checking element is present in the launch page (Search. Book. Go.)
	 */
	public boolean validateElementPresent()
	{
		return (validateText.isDisplayed());
	}
	
	/*
	 * Validate the result page 
	 * Enter From – Pune , To – Hyderabad , Departure – 17 Sep 2020 , Return – 24 Oct 2020 , Travelers - 2
	 * Click on search 
	 * Validate the search result
	 */
	public boolean searchFlightAndValidate() throws InterruptedException 
	{
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   
		fromPlace.click();
		fromPlace.clear();
		fromPlace.sendKeys(GenericConstants.source);
		Thread.sleep(4000);
		selectAutosuggestedValue(GenericConstants.source);
		toPlace.click();
		toPlace.clear();
		toPlace.sendKeys(GenericConstants.destination);
		Thread.sleep(4000);
		selectAutosuggestedValue(GenericConstants.destination); 
		depature.click();
		departureDateSelection.click();
		if (close.isDisplayed()) {
		close.click();
		}
		returnslection.click();
		forwardArrow.click();
		Actions ac=new Actions(driver);
		ac.moveToElement(returnDateSelection).click().perform();
		travelersTab.click();
		travelersCount.click();
		search.click();
		Thread.sleep(3000);
		//Validate selected tip departure and return date, Book field is enabled in the search page and list of airline for the selected date is displayed 
		return (tipStartDate.isDisplayed() && tipReturnDate.isDisplayed()) && bookField.isEnabled();

		
	}
	
	/*Common method to select the auto suggested drop values for source and destination field */
	
	public void selectAutosuggestedValue(String value)
	{

		for(int i=0;i<cityNamesAutoSuggest.size();i++)
		  {
		   String cityName_suggestBox = cityNamesAutoSuggest.get(i).getText().toLowerCase() ; 
		   if(cityName_suggestBox.contains(value.toLowerCase()))
		   {
			   cityNamesAutoSuggest.get(i).click();
			  
		   }
		   
		  } 
	}
	
	
	/*Select- Non stop, depature time (00.00-06:00) and Airline -Air India Filter */
	public String filter() throws InterruptedException
	{
		//Click non stop filter 
		filterNonStop.click();
		//select departure filter - 00.00-06:00
		filterDepature.click();
		//Select airline filters - Air India
		filterAirline.click();
		Thread.sleep(3000);
		String filterSlectionValidation= slectedFilterInfo.getAttribute("innerText");
		return filterSlectionValidation;
		//System.out.println(filterSlectionValidation);
	}
	
	
		
	//Display the list of airline details price <5000
		public boolean listOfAirlinepriceLessFiveHund() throws InterruptedException 
		
		{
		
		Thread.sleep(3000);
		 //System.out.println(airlinePriceDetails.size());
		 List<Integer> all_elements_text=new ArrayList<Integer>();
		 
		 List<String> all_elements_text2=new ArrayList<String>();
		 
		 String airlineDetails;
		 for(int i=0;i<airlinePriceDetails.size();i++)
		  {
			
			 all_elements_text.add(Integer.parseInt(airlinePriceDetails.get(i).getText()));
			//System.out.println(all_elements_text);  
			 Thread.sleep(3000);
			for(int k=0;k<airlineResultPuneToHyd.size();k++)
			{
			airlineDetails=airlineResultPuneToHyd.get(k).getText();
		  
			for(int j=0;j<=all_elements_text.size()-1;j++)
				{
				if(all_elements_text.get(j)<5000)
				{
				System.out.println(all_elements_text.get(j));
				String s=all_elements_text.get(j).toString();
			
				if(airlineDetails.contains(s))
				{
				System.out.println(all_elements_text2); 
				return true;
				}
				
				}
				}
			}
		  }
		 return false;
		}
			
}	  
	
		 
		 


		 
	


		
		
		


	




		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

