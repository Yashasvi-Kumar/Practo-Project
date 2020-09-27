package review;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot
{
		
		 public static void Capture_ScreenShot(WebDriver driver, String ScreenShotName) 
		 {
			 String timeStamp;
			 try
			 {
				 File screenshots=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
				 FileUtils.copyFile(screenshots,new File("C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\Screenshot",timeStamp+".jpg"));
			 }
			 catch (Exception e)
			 {
				 System.out.println(e.getMessage());
				 e.printStackTrace();
			 }
		 }
	
}