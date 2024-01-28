package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.pages.CartPage;

import reports.ExtentReportsDemo;

public class CartTests extends BaseTest {
	
	@BeforeSuite
	public void setUpExtentReports() {
	    ExtentReportsDemo.reportSetup();
	}

	@Test
	public void clickCart() {
		
		ExtentTest productElement = extent.createTest("Test for adding to cart", "cart adding");
		CartPage cartPage = new CartPage();
		System.out.println("adding to cart..");
		
		cartPage.clickCart();
		productElement.log(Status.PASS, "successfully added to cart..");
	}

	@Test
	public void clickCheckOut() throws InterruptedException {
		
		ExtentTest checkoutElement = extent.createTest("Test for checkout..", "checkout test");
		CartPage cartPage = new CartPage();
		System.out.println("clicking checkout");
		Thread.sleep(2000);
		cartPage.check();
		checkoutElement.log(Status.PASS, "successfully clicking on checkout button..");
	}

	@Test
	public void enterFirstName() throws InterruptedException {
		
		ExtentTest checkoutFirstNameElement = extent.createTest("Test for first name input..", "firstname input");
		CartPage cartPage = new CartPage();
		Thread.sleep(2000);
		System.out.println("Entering first name..");
		cartPage.firstName();
		checkoutFirstNameElement.log(Status.INFO, "entering first name..");
	}

	@Test
	public void enterLastName() throws InterruptedException {
		
		ExtentTest checkoutLastNameElement = extent.createTest("Test for last name input..", "lastname input");
		CartPage cartPage = new CartPage();
		Thread.sleep(2000);
		System.out.println("Entering last name..");
		cartPage.lastName();
		checkoutLastNameElement.log(Status.INFO, "entering last name..");
		
	}

	@Test
	public void enterPostalCode() throws InterruptedException {
		
		ExtentTest postalCodeElement = extent.createTest("Test for postal code input..", "postalcode input");
		CartPage cartPage = new CartPage();
		Thread.sleep(2000);
		System.out.println("Entering postal code..");
		cartPage.postalCode();
		postalCodeElement.log(Status.INFO, "entering postal code..");
	}

	@Test(dependsOnMethods = { "enterFirstName", "enterLastName", "enterPostalCode" })
	public void cont() throws InterruptedException {
		
		ExtentTest continitueBtnElement = extent.createTest("Test for continiue button element..", "continiue");
		CartPage cartPage = new CartPage();
		Thread.sleep(2000);
		System.out.println("Clicking continiue..");
		cartPage.pressCont();
		continitueBtnElement.log(Status.INFO, "Clicking on continiue button..");
	}

	@Test(dependsOnMethods = { "cont" })
	public void swipingToFinishBtn() throws InterruptedException {
		
		ExtentTest swipeOnFinish = extent.createTest("Test for swiping to finish element..", "finish element swiping");
		CartPage cartPage = new CartPage();
		Thread.sleep(2000);
		System.out.println("Swiping to finish....");
		cartPage.swipeDiv();
		swipeOnFinish.log(Status.INFO, "swiped to finish element..");
	}

	@Test(dependsOnMethods = { "swipingToFinishBtn" })
	public void clickOnFinish() throws InterruptedException {
		
		ExtentTest clickingFInishElement = extent.createTest("Test for clicking on finish lement..", "finish element clicking");
		CartPage cartPage = new CartPage();
		Thread.sleep(2000);
		System.out.println("Clicking on finish....");
		cartPage.finishEl();
		Thread.sleep(2000);
		System.out.println("Test is finished.");
		clickingFInishElement.log(Status.INFO, "clicked on Finish element..");
	}
	
	  @AfterSuite
	  public void tearDownExtentReports() {
	      ExtentReportsDemo.reportTearDown();
	  }
  
}