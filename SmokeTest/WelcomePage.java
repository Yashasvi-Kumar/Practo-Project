package SmokeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.Driver_Setup;
//import Utilities.ReadConfigFile;


public class WelcomePage
{
	WebDriver driver;
	Properties prop;
	//ReadConfigFile cfg=new ReadConfigFile();
	
	@BeforeTest
	public void SetUp() throws Exception 
	{
	 	Driver_Setup ds=new Driver_Setup();
		driver=ds.getWebDriver(prop.getProperty("Browser"));  
	}
	
	@Test(priority = 1)
	public void PageTitleCheck() 
	{
		String Actual_Title = driver.getTitle();
		String Expected_Title = "Practo | Book Doctor Appointments Online, Order Medicine, Diagnostic Tests, Consult";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		Reporter.log("---Page Title Checked", true);
	}
	
	@Test(priority = 2)
	public void LoginSignupButtonVisibilityCheck() 
	{
		Boolean Login_Signup_Button = driver.findElement(By.xpath("//a[@name='Practo login']")).isDisplayed();
		Assert.assertTrue(Login_Signup_Button);
		
		Reporter.log("---Login/Signup Button Visibility Checked", true);
	}
	
	@Test(priority = 3)
	public void LocationTextFieldVisibilityCheck()
	{
		Boolean Location_TextField = driver.findElement(By.xpath("//input[@placeholder='Search location']")).isDisplayed();
		Assert.assertTrue(Location_TextField);
		
		Reporter.log("---Search Location TextField Visibility Checked", true);
	}
	
	@Test(priority = 4)
	public void DetectButtonVisibilityCheck() 
	{
		Boolean Detect_Button = driver.findElement(By.xpath("//span[@class='c-omni-searchbox__button-container']")).isDisplayed();
		Assert.assertTrue(Detect_Button);
		
		Reporter.log("---Detect Location Button Visibility Checked");
	}
	
	@Test(priority = 5)
	public void SearchTextFieldVisibilityCheck() 
	{
		Boolean Search_TextField =  driver.findElement(By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']")).isDisplayed();
		Assert.assertTrue(Search_TextField);
		
		Reporter.log("---Search doctor, clinics, hospitals, etc Input TextField Visibility Checked", true);
		
	}
	
	@AfterTest
	public void TearDown() 
	{
		driver.close();
		Reporter.log("---Browser Closed",true);
	}
	
}
