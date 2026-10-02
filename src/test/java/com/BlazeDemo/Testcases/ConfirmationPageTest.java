package com.BlazeDemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BlazeDemo.Pages.BaseTest;
import com.BlazeDemo.Utilities.ExcelDataUtil;

public class ConfirmationPageTest extends BaseTest {
	@DataProvider(name = "purchasePageData")
	public Object[][] getPurchaseData() {
	    return ExcelDataUtil.getSheetData("formDetails");
	}
	
	@Test(priority=0)
	public void setup() {
homePage.SelectDepartureCity("Boston");
homePage.SelectDestinationCity("London");
reservePage=homePage.ClickFindFlights();
reservePage.getChooseFlightBtn();
	}

	
	@Test(dataProvider = "purchasePageData", priority = 1)
	public void purchase(String cname, String addr, String ccity, String cstate,
	                                 String zip,String ccnum, String ccmonth, String ccyear, String nameCard) {
	 
	  purchasePage.fillPurchaseForm(cname, addr, ccity, cstate, zip,ccnum, ccmonth, ccyear, nameCard);
	
  }
	@Test(priority=2)
	  public void clickpurchase() {
		
		purchasePage.purchaseFlightButton();
	  }
	
  @Test(priority=2)
  public void verifyConfirmationMsg() {
	  
	  confirmationPage.getConfirmationMessage();
	  Assert.assertTrue("Thank you for your purchase today!".contains(confirmationPage.getConfirmationMessage()), "The confirmation message is not displayed...Please check the application");
  }
}
