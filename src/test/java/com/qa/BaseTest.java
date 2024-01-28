package com.qa;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import reports.ExtentReportsDemo;

public class BaseTest extends ExtentReportsDemo{
	
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;
	//protected ExtentReports extent;
	
	public BaseTest() {
		// Auto initialize elements on the page
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@Parameters({"platformName", "deviceName"})
	
	
  @BeforeTest
  public void beforeTest(String platformName, String deviceName) throws Exception {
	  
		try {
			props = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("automationName", props.getProperty("iOSAutomationName"));
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", "183E6756-60FA-43CD-8DF6-35AB4D1EA61A");// 11

			String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "app" + File.separator
					+ "iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app";

			desiredCapabilities.setCapability("app", appUrl);
			URL url = new URL(props.getProperty("appiumURL"));

			driver = new IOSDriver(url, desiredCapabilities);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	  
  }
	// WaitForVIsibility of elements Method
	public void waitForVisibility(WebElement e) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
		wait.until(ExpectedConditions.visibilityOf(e));
		
	}

	public void click(WebElement e) {
	waitForVisibility(e);
		e.click();
	}

	public void sendKeys(WebElement e, String txt) {
		waitForVisibility(e);
		e.sendKeys(txt);
	}
	
	//Method for driver command for get attribute
	public String getAttribute(WebElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
		
	}
	

	public void swipeProducts(WebElement e) {
	    waitForVisibility(e);
	    Map<String, Object> params = new HashMap<>();
	    params.put("direction", "up");
	    params.put("element", ((RemoteWebElement) e).getId());
	    driver.executeScript("mobile: swipe", params);
	}
	
    public void takeScreenshot() throws IOException {
        // Get current time
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

        // Date formated
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh mm ss");
        String fileName = sdf.format(date);

        // ScreenShot recording
        File des = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(des, new File(System.getProperty("user.dir") + "//Screenshot//" + fileName + ".png"));
        System.out.println("Screenshot is captured!");
    }


  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(2000);
	 driver.quit();
  }

}
