package com.frameworks.pages;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TheAppPage {

	
	@AndroidFindBy(accessibility = "Echo Box")
	public AndroidElement echobox;
	
	
	@AndroidFindBy(accessibility = "messageInput")
	public AndroidElement messageInput;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='messageSaveBtn']/android.widget.TextView")
	public AndroidElement submitButton;

	public TheAppPage(AppiumDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void caoDjaciFlow(String poruka) {
		echobox.click();
		messageInput.sendKeys(poruka);
		submitButton.click();
	}


	

	
	
	
	
	
	

}
