package com.BlazeDemo.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BlazeDemo.Utilities.ElementUtil;


public class PurchasePage {
	
	private WebDriver driver;
    public PurchasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    
    @FindBy(id="inputName")
    private WebElement nameField;
    @FindBy(name="address")
    private WebElement addressField;
    @FindBy(id="city")
    private WebElement cityField;
    @FindBy(id="state")
    private WebElement stateField;
    @FindBy(id="zipCode")
    private WebElement zipCodeField;
    @FindBy(xpath="//div/select[@id='cardType']")
    private WebElement cardTypeDropdown;
    @FindBy(id="creditCardNumber")
    private WebElement creditCardNumberField;
    @FindBy(id="creditCardMonth")
    private WebElement creditCardMonthField;
    @FindBy(id="creditCardYear")
    private WebElement creditCardYearField;
    @FindBy(id="nameOnCard")
    private WebElement nameOnCardField;
    @FindBy(id="rememberMe")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath="//input[@type='submit']")
    private WebElement purchaseFlightButton;
    
   public PurchasePage fillPurchaseForm(String cname, String addr, String ccity, String cstate,
           String zip,String ccnum, String ccmonth,
           String ccyear, String nameCard) {
	  
	   nameField.clear();
	   nameField.sendKeys(cname);
	   addressField.clear();
	   addressField.sendKeys(addr);
	   cityField.clear();
	   	cityField.sendKeys(ccity);
	   	stateField.clear();
	   	stateField.sendKeys(cstate);
	   	zipCodeField.clear();
	   	zipCodeField.sendKeys(zip);
	   	Select selectCardType = new Select(cardTypeDropdown);
	   	selectCardType.selectByVisibleText("Visa");
	   	creditCardNumberField.clear();
	   	creditCardNumberField.sendKeys(ccnum);
	   	creditCardMonthField.clear();
	   	creditCardMonthField.sendKeys(ccmonth);
	   	creditCardYearField.clear();
	   	creditCardYearField.sendKeys(ccyear);
	   	nameOnCardField.clear();
	   	nameOnCardField.sendKeys(nameCard);
	   	rememberMeCheckbox.click();
		purchaseFlightButton.click();
		ElementUtil.waitForPageLoad(driver);
		driver.navigate().back();
		return new PurchasePage(driver);

	}
   
   public ConfirmationPage purchaseFlightButton() {
	   purchaseFlightButton.click();
	  return new ConfirmationPage(driver);
   }
	
	
	
}
