package com.qa.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

import reports.ExtentReportsDemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest {
	
	@BeforeSuite
	public void setUpExtentReports() {
	    ExtentReportsDemo.reportSetup();
	    
	}

	
	// Initialize class LoginPage
	LoginPage loginPage;
	//Initialize class ProductsPage
	ProductsPage productsPage;

	@BeforeMethod
	public void beforeMethod(Method m) {
		
		loginPage = new LoginPage();
		System.out.println("\n" + "***** starting test: " + m.getName() + "*******" + "\n");
	}


	// Testing Login Page With Invalid User name

	@Test
	public void invalidUserName() throws InterruptedException, IOException {
		
		ExtentTest invalidUsername = extent.createTest("Test for invalid username", "invalid username");
		
		try {
			invalidUsername.log(Status.PASS, "Test for invalid username started..");
			
			loginPage.usernameTxtFld.clear();
			Thread.sleep(2000);
			
			invalidUsername.log(Status.INFO, "entering invalid username..");
			loginPage.enterUserName("invalidusername");
			Thread.sleep(2000);
			
			invalidUsername.log(Status.INFO, "entering valid password..");
			loginPage.enterPassword("secret_sauce");
			Thread.sleep(2000);
			
			invalidUsername.log(Status.INFO, "clicked on Login button..");
			loginPage.pressLoginBtn();
			Thread.sleep(2000);
			
		} catch(Exception e){
		    System.out.println("An error occurred: " + e.getMessage());
		    invalidUsername.log(Status.ERROR, "An error occurred: " + e.getMessage());
		    takeScreenshot();
			
			
		}
		String actualErrTxt = loginPage.getErrTxt();
		Thread.sleep(2000);
		String expectedErrTxt = "Username and password do not match any user in this service.";
		System.out.println("actual error text - " + actualErrTxt + "\n" + "expected error text -" + expectedErrTxt);
		Thread.sleep(2000);
		Assert.assertEquals(actualErrTxt, expectedErrTxt);
		
		takeScreenshot();
		invalidUsername.log(Status.FAIL, "Test failed. Provided invalid username..");

	}
	 
	
	@Test (dependsOnMethods = {"invalidUserName"})
	
	public void invalidPassword() throws InterruptedException, IOException {
		
		ExtentTest invalidPassword = extent.createTest("Test for invalid password", " username invalid");
		
		try {
			// Name of the text in extent reports
			invalidPassword.log(Status.PASS, "Test for invalid password started..");
			
			Thread.sleep(2000);
			loginPage.usernameTxtFld.clear();
			loginPage.passwordTxtFld.clear();
			
			invalidPassword.log(Status.INFO, "entering valid username..");
			loginPage.enterUserName("standard_user");
			Thread.sleep(2000);
			
			invalidPassword.log(Status.INFO, "entering invalid password..");
			loginPage.enterPassword("invalidpassword");
			Thread.sleep(2000);
			
			invalidPassword.log(Status.INFO, "clicked on Login button..");
			loginPage.pressLoginBtn();
			Thread.sleep(2000);
			
		} catch(Exception e) {

	}
		String actualErrTxt = loginPage.getErrTxt();
		String expectedErrTxt = "Username and password do not match any user in this service.";
		System.out.println("actual error text - " + actualErrTxt + "\n" + "expected error text -" + expectedErrTxt);
		Assert.assertEquals(actualErrTxt, expectedErrTxt);
		
		takeScreenshot();
		invalidPassword.log(Status.FAIL, "Test failed. Provided invalid password.. ");
}
	 
	
	@Test(dependsOnMethods = {"invalidUserName","invalidPassword"})
	public void successfulLogin() throws InterruptedException {
		
		// Name of the text in extent reports
		ExtentTest successfulLogin = extent.createTest("Test for successful Login", " Login Success");
		
		successfulLogin.log(Status.PASS, "Successfull login Test started.");
		
		
		Thread.sleep(2000);
		loginPage.usernameTxtFld.clear();
		// We are on the login page
		// Entering Valid user name from method enterUsername from class LoginPage
		
		successfulLogin.log(Status.INFO, "Entering valid username..");
		loginPage.enterUserName("standard_user");
		Thread.sleep(2000);
		loginPage.passwordTxtFld.clear();
		
		// Entering invalid password
		successfulLogin.log(Status.INFO, "Entering valid password..");
		loginPage.enterPassword("secret_sauce");
		Thread.sleep(2000);
		// Now we are on Products Page 
		productsPage = loginPage.pressLoginBtn();
		//Thread.sleep(2000);
		// Get PRODUCTS title from Products Page
		String actualProductTitle = productsPage.getTitle();
		String expectedProductTitle = "PRODUCTS";
		System.out.println("product title - " + actualProductTitle + "\n"+ "expected title - " + expectedProductTitle);
		
		
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		
		successfulLogin.log(Status.PASS, "This test is showing Successfull login");
	}
	
	@AfterSuite
	public void tearDownExtentReports() {
	    ExtentReportsDemo.reportTearDown();
	}


}
