package com.BlazeDemo.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage {
 private WebDriver driver;
 public ReservePage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
 
 
 @FindBy(xpath="(//table//tr/td[3]/preceding::td/input[@type='submit'])[2]")
 private WebElement chooseFlightBtn;
 @FindBy(xpath="//table//tr[1]/th")
 private List<WebElement> flightDetailsHeader;
 @FindBy(xpath="//table//tr")
 private List<WebElement> flightDetailsRow;
 @FindBy(xpath="//h3")
 private WebElement flightDetailsTitle;
 
 public String getFlightDetailsTitle() {
	 return flightDetailsTitle.getText();
 }
 public List<WebElement> getFlightDetailsHeader() {
	 int count = flightDetailsHeader.size();
	 System.out.println("The number of columns in the flight details table is : "+count);
	 for(WebElement Headernames:flightDetailsHeader) {
		System.out.println(Headernames.getText());
	 }
	return flightDetailsHeader;
 }
 
 public int getFlightDetailsRow() {
	 return flightDetailsRow.size();
	  }
 
 public PurchasePage getChooseFlightBtn() {
	 chooseFlightBtn.click();
	 return new PurchasePage(driver);
 }
}
