package com.qa.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.qa.BaseTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductsPage extends BaseTest{
	
	AppiumDriver driver;
	
	// Find element "Products" to be sure we are on Products Page
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name == \"PRODUCTS\"`]")
				private WebElement productTitleText;
	
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeApplication[@name=\"SwagLabsMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther")
				public WebElement divProducts;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name == \"test-Item title\"`][1]")
				public WebElement backpackClick;
	
	@iOSXCUITFindBy(accessibility="test-ADD TO CART") WebElement addToCart;
	
	
	public String getTitle() {
		return getAttribute(productTitleText,"name");

	}
	
	
	public void pressBackpack() {
		click(backpackClick);
	}
	
	public void swipeBackPack() {
		
		swipeProducts(divProducts);
	}
	
	public void addToCart() {
		click(addToCart);
	}
	
}