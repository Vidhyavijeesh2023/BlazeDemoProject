package com.BlazeDemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BlazeDemo.Pages.BaseTest;

public class HomePageTest extends BaseTest{
	@Test(priority=1)
	  public void VerifyURL() {
		  String URL=homePage.PageUrl();
		  Assert.assertTrue(URL.contains("blazedemo"));
		  System.out.println("The URL is correct :"+URL);
		   
	  }
	@Test(priority=2)
	  public void VerifyTitle() {
		 String TITLE= homePage.Title();
		 Assert.assertTrue(TITLE.contains("BlazeDemo"));
		 System.out.println("The Title is correct :"+TITLE);
	}
	 @Test(priority=3)
	public void VerifyHeader() {
			 String HEADER= homePage.HomepageHeader();
			 Assert.assertTrue(HEADER.contains("Welcome to the Simple Travel Agency!"));
			 System.out.println("The Header is correct :"+HEADER); 
		  }
	 @Test(priority=4)
	 public void VerifyText1() {
		 String TEXT1= homePage.HomepageText1();
			 Assert.assertTrue(TEXT1.contains("The is a sample site you can test with BlazeMeter!"));
			 System.out.println("The Text1 is correct :"+TEXT1); 
	 }
	 @Test(priority=5)
	 public void VerifyText2() {
		 String TEXT2= homePage.HomepageText2();
			 Assert.assertTrue(TEXT2.contains("Check out"));
			 System.out.println("The Text2 is correct :"+TEXT2);
	 }
	  
  @Test(priority=6)
  public void VerifyDepartureCity() {
	  String city1=homePage.SelectDepartureCity("Mexico City");
	  Assert.assertTrue(city1.contains("Mexico"));
	  System.out.println("The Departure City is correct :"+city1);
  }
  @Test(priority=7)
  public void VerifyDestinationCity() {
	 
	    String city2=homePage.SelectDestinationCity("Berlin");
	  Assert.assertTrue(city2.equals("Berlin"));
	  System.out.println("The Destination City is correct :"+city2);
  }
  @Test(priority=8)
  public void VerifyReservePage() {
	  homePage.ClickFindFlights();
	  String reserveURL=homePage.PageUrl();
	  Assert.assertTrue(reserveURL.contains("reserve"),"Reserve page URL is not correct");
	  System.out.println("The Reserve page URL is correct :"+reserveURL);
	  
  }
  
  
}
