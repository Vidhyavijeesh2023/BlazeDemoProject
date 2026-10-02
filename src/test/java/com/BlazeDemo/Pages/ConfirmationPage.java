package com.BlazeDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
  private WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath="//h1[contains(text(),'Thank you for your purchase today!')]")
	private WebElement confirmationMessage;
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
		
	}

	
	

}
