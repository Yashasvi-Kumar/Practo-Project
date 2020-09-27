package practo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

//import Utilities.ReadConfigFile;

public class Dash {
	WebDriver driver;
	Properties prop;
	InputStream readFile;

	public Dash(WebDriver dr) {
		this.driver = dr;
	}

	public void Practo_Login_Signup() {
		WebElement Practo_Login_Signup = driver.findElement(By.xpath("//a[@name='Practo login']"));
		Practo_Login_Signup.click();

		Reporter.log("---Login/Signup Button Clicked", true);
	}

	public void MobileNumber_EmailId() {
		prop = new Properties();
		try {
			readFile = new FileInputStream(
					"C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MobileNumber_EmailId = driver.findElement(By.xpath("//input[@id='username']"));
		MobileNumber_EmailId.sendKeys(prop.getProperty("Mobile_Number"));

		Reporter.log("---Login MobileNumber/EmailId Entered", true);
	}

	public void Password() {
		prop = new Properties();
		try {
			readFile = new FileInputStream(
					"C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys(prop.getProperty("Password"));

		Reporter.log("---Login Password Entered", true);
	}

	public void RememberMe_CheckBox() {
		WebElement RememberMe_CheckBox = driver.findElement(By.xpath("//div[@class='remember']//label"));
		RememberMe_CheckBox.click();

		Reporter.log("---Login RememberMe CheckBox Clicked", true);
	}

	public void Login_Button() {
		WebElement Login_Button = driver.findElement(By.xpath("//button[@id='login']"));
		Login_Button.click();

		Reporter.log("---Login Button Clicked and Navigated To Next Page", true);
	}

}
