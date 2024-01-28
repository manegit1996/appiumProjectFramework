package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

import reports.ExtentReportsDemo;


public class ProductsTests extends BaseTest{
	
	@BeforeSuite
	public void setUpExtentReports() {
	    ExtentReportsDemo.reportSetup();
	}

  @Test
	public void pressBtn ()  throws Exception {
	  
	  ExtentTest productElement = extent.createTest("Test for clicking on product", "item clicking");
 
	    try {
	    	productElement.log(Status.PASS, "Starting test for clicking on product..");
	        // Initialize Products Page Class
	        ProductsPage productsPage = new ProductsPage();
	        Thread.sleep(2000);
	        
	        
	      
	        // If element is visible
	        if(productsPage.backpackClick.isDisplayed()) {
	            // Click on it
	        	productElement.log(Status.INFO, "checking if product is displayed on the page..");
	            System.out.println("Element is visible. Clicking..");
	            
	            productsPage.pressBackpack();
	            productElement.log(Status.PASS, "clicking on product..");
	            
	        } else {
	            System.out.println("Element is not visible.");
	            productElement.log(Status.ERROR, "product is not visible on the page..");
	            takeScreenshot();

	        }
	    } catch (Exception e){
	        Thread.sleep(2000);
	        System.out.println("An error occurred: " + e.getMessage());
	     
	        throw e;
	    }
	  
	  
  	}
	
  @Test (dependsOnMethods = {"pressBtn"})
	public void swipe() throws InterruptedException {
	 
	ExtentTest swipeElement = extent.createTest("Test for swipe", "swiping test");
	  
	ProductsPage productsPage = new ProductsPage();
	System.out.println("Swiping..");
	Thread.sleep(2000);
	
	productsPage.swipeBackPack();
	swipeElement.log(Status.INFO, "element swiped");
	
	}
  
  @Test (dependsOnMethods = {"pressBtn", "swipe"})
  public void addCart() throws InterruptedException {
	  
	  ExtentTest addElementToCart = extent.createTest("Test for adding el to cart", "adding to cart");
	  
	  ProductsPage productsPage = new ProductsPage();
	  Thread.sleep(2000);
	  
	  productsPage.addToCart();
	  addElementToCart.log(Status.INFO, "element added to cart");
  }
  
  @AfterSuite
  public void tearDownExtentReports() {
      ExtentReportsDemo.reportTearDown();
  }

  
  }