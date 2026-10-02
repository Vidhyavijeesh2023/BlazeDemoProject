package com.BlazeDemo.Testcases;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BlazeDemo.Pages.BaseTest;

public class ReservePageTest extends BaseTest {
	
@BeforeClass
public void setup() {
homePage.SelectDepartureCity("Boston");
homePage.SelectDestinationCity("London");
reservePage=homePage.ClickFindFlights();
}

  @Test(priority=1)
  public void VerifyTitle() {
	  String Title=reservePage.getFlightDetailsTitle();
	  Assert.assertTrue(Title.contains("Flights from Boston to London"), "the heading is not correct...Please check the application");
	  System.out.println("The heading of the page is : "+Title+" which is correct as per the selected departure and destination cities");
  }
  @Test(priority=2)
  public void VerifyRow() {
	 int counts= reservePage.getFlightDetailsRow();
	 Assert.assertEquals(6, counts);
	 System.out.println("The number of rows in the flight details table is : "+counts); 
  }
  @Test(priority=3)
  public void Verifyheadings() {
	int Headingcount=reservePage.getFlightDetailsHeader().size();
	Assert.assertEquals(Headingcount, 6);
  }
  @Test(priority=4)
  public void VerifyChooseFightbtn() {
	reservePage.getChooseFlightBtn();
	Assert.assertTrue(driver.getCurrentUrl().contains("purchase"), "The choose flight button is not working as expected...Please check the application");
    System.out.println("The choose flight button is working as expected and the user is navigated to the purchase page with the url : "+driver.getCurrentUrl());
  }
  
  
  
  
  
}
