package com.BlazeDemo.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.BlazeDemo.Utilities.BrowserProvider;



public class BaseTest {
	
	protected WebDriver driver;
	protected HomePage homePage;
	protected ReservePage reservePage;
	protected PurchasePage purchasePage;
	protected ConfirmationPage confirmationPage;
	

	@Parameters({"bname"})
	@BeforeClass
	public void setup(String bname) {
		driver=BrowserProvider.setDriver(bname);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://blazedemo.com/");
		homePage=new HomePage(driver);
		reservePage=new ReservePage(driver);
		purchasePage=new PurchasePage(driver);
		confirmationPage=new ConfirmationPage(driver);
		
	}
	@AfterClass
	public void teardown() {
		BrowserProvider.getDriver().quit();
	}

}
