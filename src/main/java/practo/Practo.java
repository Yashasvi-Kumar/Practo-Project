package practo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


public class Practo {
	WebDriver driver;
	Properties prop;
	InputStream readFile;
	public Practo(WebDriver dr) {
		this.driver=dr;
	}
	
	
	public void Set_Location() throws Exception
		{
		prop=new Properties();
		try {
			readFile=new FileInputStream("C:\\Users\\vcc\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		WebElement Set_Location= driver.findElement(By.xpath("//input[@placeholder='Search location']"));
		Set_Location.clear();
		Set_Location.sendKeys(prop.getProperty("Location"));
		Thread.sleep(200);
		WebElement Set_Location1= driver.findElement(By.xpath("//div[@class='c-omni-suggestion-item']"));
		Set_Location1.click();
		/*WebElement Set_Location=driver.findElement(By.xpath("//span[@class='c-omni-searchbox__button c-omni-searchbox__button']"));
		Set_Location.click();
		*/Thread.sleep(300);
		
		Reporter.log("---Location Set To Near By" , true);
	}
	
	public void Search() throws Exception 
	{
		prop=new Properties();
		try {
			readFile=new FileInputStream("C:\\Users\\vcc\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		WebElement Search=driver.findElement(By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']"));
		Search.clear();
		Search.sendKeys(prop.getProperty("Search"));
		Thread.sleep(500);
		WebElement Apply_Search=driver.findElement(By.xpath("//body/div[@id='root']/div/div/div[@class='content']/div[@class='c-omni-wrapper u-d__inline-block']/div[@id='c-omni-container']/div[@class='c-omni u-clearfix']/div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--keyword']/div[@class='c-omni-suggestion-list']/div[1]/div[1]/span[1]"));
		Apply_Search.click();
		Reporter.log("---Search Applied", true);
	}
	
}
