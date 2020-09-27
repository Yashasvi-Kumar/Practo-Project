package SmokeTest;

import java.io.FileReader;
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

public class Login 
{
		WebDriver driver;
	//ReadConfigFile cfg=new ReadConfigFile();
	@BeforeTest
	public void SetUp() throws Exception
	{  
		Driver_Setup ds=new Driver_Setup();
		driver=ds.getWebDriver("chrome");  
	}
	
	@Test(priority= 1)
	public void LoginSignup() 
	{
		WebElement Practo_Login_Signup = driver.findElement(By.xpath("//a[@name='Practo login']"));
		Practo_Login_Signup.click();
		
		Reporter.log("---Login/Signup Button Clicked", true);
	}
	
	@Test(priority= 2)
	public void LoginLinkTabVisibilityCheck() 
	{
		Boolean Login_Tab= driver.findElement(By.xpath("//a[@id='loginLink']")).isDisplayed();
		Assert.assertTrue(Login_Tab);
		
		Reporter.log("---Login Tab Visibility Checked");
		
	}
	
	@Test(priority= 3)
	public void MobileEmailTextFieldVisibilityCheck()
	{
		Boolean MobileEmail_TextField= driver.findElement(By.xpath("//input[@id='username']")).isDisplayed();
		Assert.assertTrue(MobileEmail_TextField);
		
		Reporter.log("---Mobile/Email Id Input TextField Visibility Is Checked");
	}
	
	@Test(priority= 4)
	public void PasswordTextFieldVisibiltyCheck()
	{
		Boolean Password_TextField= driver.findElement(By.xpath("//input[@id='password']")).isDisplayed();
		Assert.assertTrue(Password_TextField);
		
		Reporter.log("---Password Input TextField Visibility Is Checked", true);
	}
	
	@Test(priority= 5)
	public void RememberMeCheckBoxVisibilityCheck()
	{
		Boolean RememberMe_CheckBox= driver.findElement(By.xpath("//div[@class='remember']//label")).isDisplayed();
		Assert.assertTrue(RememberMe_CheckBox);
		
		Reporter.log("---RememebrMe CheckBox Visibility Is Checked", true);
	}
	
	@Test(priority= 6)
	public void LoginWithOtpVisibilityCheck() 
	{
		Boolean LoginOTP_CheckBox= driver.findElement(By.xpath("//div[@class='otp_flow']//label")).isDisplayed();
		Assert.assertTrue(LoginOTP_CheckBox);
		
		Reporter.log("---Login With OTP Insted Of Password CheckBox Visibility Checked", true);
	}
	
	@Test(priority= 7)
	public void LoginButtonVisibilityCheck()
	{
		Boolean Login_Button= driver.findElement(By.xpath("//button[@id='login']")).isDisplayed();
		Assert.assertTrue(Login_Button);
		
		Reporter.log("---Login Button Visibility Checked", true);
	}
	
	@AfterTest
		public void TearDown() 
		{
			driver.close();
			Reporter.log("---Browser Closed",true);
		}
}
