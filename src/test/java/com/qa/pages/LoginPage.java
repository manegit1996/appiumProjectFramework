package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.BaseTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BaseTest{
	
	AppiumDriver driver;
	
	// Finding Elements on the first page using TesNg annotations
	@iOSXCUITFindBy(accessibility ="test-Username") public WebElement usernameTxtFld;
	@iOSXCUITFindBy(id="test-Password") public WebElement passwordTxtFld;
	@iOSXCUITFindBy(id="test-LOGIN") public WebElement loginBtn;
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Username and password do not match any user in this service.\"]") 
					public WebElement errTxt;
	
	
	
	public LoginPage enterUserName(String username) {
		// Method SendKeys from BaseTest Class
		// On that web element send me user name Keys
		sendKeys(usernameTxtFld,username);
		
		// Returning reference on particular Object
		return this;
		
	}
	
	public LoginPage enterPassword(String password) {
		sendKeys(passwordTxtFld,password);
		return this;
	}
	
	public ProductsPage pressLoginBtn() {
		
		click(loginBtn);
		return new ProductsPage();
		
	}
	public String getErrTxt() {
		return getAttribute(errTxt,"name");
		
	}

}