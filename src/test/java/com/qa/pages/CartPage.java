package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CartPage extends BaseTest{
	AppiumDriver driver;

	@iOSXCUITFindBy(accessibility = "test-Cart")
			public WebElement cartElement;
	@iOSXCUITFindBy(accessibility = "test-REMOVE")
			public WebElement removeElement;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-CHECKOUT\"]")
			public WebElement checkOutElement;
	@iOSXCUITFindBy(accessibility = "test-First Name")
			public WebElement firstNameElement;
	@iOSXCUITFindBy(accessibility = "test-Last Name")
			public WebElement lastNameElement;
	@iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
			public WebElement postalCodeElement;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-CONTINUE\"]")
			public WebElement continiueElement;
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
			public WebElement swipeDivElement;
	@iOSXCUITFindBy(accessibility = "test-FINISH")
			public WebElement finishElement;

	public void clickCart() {
		click(cartElement);

	}

	public void check() {
		click(checkOutElement);
	}

	public void firstName() {
		sendKeys(firstNameElement, "TestFirstName");

	}

	public void lastName() {
		sendKeys(lastNameElement, "TestLastName");

	}

	public void postalCode() {
		sendKeys(postalCodeElement, "11080");
	}

	public void pressCont() {
		click(continiueElement);
	}

	public void swipeDiv() {
		swipeProducts(swipeDivElement);
	}

	public void finishEl() {
		click(finishElement);
	}
}
