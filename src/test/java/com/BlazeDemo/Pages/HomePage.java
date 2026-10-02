package com.BlazeDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	
	private WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="fromPort")
	private WebElement DepartureCity;
	@FindBy(name="toPort")
	private WebElement DestinationCity;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement FindFlights;
	@FindBy(xpath="//h1")
	private WebElement HomePageHeader;
	@FindBy(xpath="(//p)[1]")
	private WebElement HomePagetext1;
	@FindBy(xpath="(//p)[2]")
	private WebElement HomePagetext2;
	
	
	public String Title() {
		return driver.getTitle();
	}
	public String PageUrl() {
		return driver.getCurrentUrl();
	}
	public String HomepageHeader() {
		return HomePageHeader.getText();
	}
	public String HomepageText1() {
		return HomePagetext1.getText();
	}
	public String HomepageText2() {
		return HomePagetext2.getText();
	}
	
	public String SelectDepartureCity(String city) {
		Select sc=new Select(DepartureCity);
		sc.selectByContainsVisibleText(city);
		return city;
	}
	
	public String SelectDestinationCity(String city) {
		Select sc=new Select(DestinationCity);
		sc.selectByContainsVisibleText(city);
		return city;
	}
	public ReservePage ClickFindFlights() {
		FindFlights.click();
		return new ReservePage(driver);
	}
	
	

	
}
