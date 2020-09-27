package review;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_Setup {
	public static WebDriver driver;
	Properties prop;
	InputStream readFile;

	public WebDriver getWebDriver(String Browser_Name) {

		if (Browser_Name.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					" C:\\Users\\vcc\\eclipse-workspace\\ReviewProject\\driveer\\geckodriver.exe ");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\driveer\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		prop = new Properties();
		try {
			readFile = new FileInputStream(
					"C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		// Reporter.log("---Browser Invoked and Navigated to URL: " +
		// prop.getProperty("Url"), true);
		return driver;

	}
}
