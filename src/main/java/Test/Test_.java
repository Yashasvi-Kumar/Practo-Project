package Test;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import practo.Dash;
import practo.NextPage;
import practo.Practo;
import review.Driver_Setup;
import review.ExtendReportManager;
import review.ScreenShot;
import review.Logs;

//import Utilities.ReadConfigFile;

public class Test_
{
	WebDriver driver;
	Dash login;
	Practo pr;
	NextPage np;
	ScreenShot shot;
	int i=0;
	Properties prop;
	InputStream readFile;
	 Logger logger;
	 ExtentReports report;
    
	 @BeforeTest
	 public void startLogger() {
		 Logs.logName("Test1");
		 Logs.startTestCase();
	 }
	 
	@Test(priority=1)
	public void Launch_Browser()
    
	{
		prop=new Properties();
		try {
			readFile=new FileInputStream("C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
			Logs.logInfo("Reading data from config file. Successful");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logs.errorMessage("Unable to read data from config file.");
		} 
		report=ExtendReportManager.getReportInstance();
		ExtentTest log=report.createTest("Launch_Browser");
		Driver_Setup ds=new Driver_Setup();
		driver=ds.getWebDriver(prop.getProperty("Browser")); 
		log.log(Status.INFO, "Initialising the browser");
		//logger.info("BrowserStarted");
		login=new Dash(driver);
		login.Practo_Login_Signup();
		//logger.info("Login page opened");
		login.MobileNumber_EmailId();
		login.Password();
		login.RememberMe_CheckBox();
		login.Login_Button();
		log.log(Status.INFO, "signing up");
		//logger.info("Login successfull");
	}	
	@Test(priority=2)
		public void HomePage_Set_Location() throws Exception
		{	//logger=Logger.getLogger("Test_");
			//PropertyConfigurator.configure("log4l.properties");
			pr=new Practo(driver);
			pr.Set_Location();
			pr.Search();
			//logger.info("Search of hospitals successfull");
			
		}
		@Test(priority = 3)
		public void HomePage_Open_24x7()
		{
			//logger=Logger.getLogger("Test_");
			//PropertyConfigurator.configure("log4l.properties");
			np=new NextPage(driver);
			np.Open_24x7();
			//logger.info("filter of 24*7 applied");
		}
		
			@Test(priority = 4)
		public void HomePage_All_Filters()
		{
				//logger=Logger.getLogger("Test_");
				//PropertyConfigurator.configure("log4l.properties");
				np=new NextPage(driver);
			np.All_Filters();
			//logger.info("All filters  applied");
		}
		
			@Test(priority = 5)
		public void HomePage_Has_Parking() 
		{
				//logger=Logger.getLogger("Test_");
				//PropertyConfigurator.configure("log4l.properties");
				np=new NextPage(driver);
			np.Sub_Filter_Has_Parking();;
			//logger.info("parking filter applied");
		}
		
			@Test(priority = 6)
		public void HomePage_Get_Hospital() 
		{
				//logger=Logger.getLogger("Test_");
				//PropertyConfigurator.configure("log4l.properties");
				np=new NextPage(driver);
			np.Get_Hospital();
			//logger.info("got hospitals");
		}	
			@Test(priority=7)
			public void HomePage_Excel_Output_Sheet() throws Exception 
			{
				//logger=Logger.getLogger("Test_");
				//PropertyConfigurator.configure("log4l.properties");
				np=new NextPage(driver);
				np.Excel_Output_Sheet();
				//logger.info("hospitals written in excel sheet");
			}
			@AfterMethod
		    public void Screen_shot(ITestResult result)
		    {
				//logger=Logger.getLogger("Test_");
				//PropertyConfigurator.configure("log4l.properties");
		               i = i+1;
		               String name = "ScreenShot";
		               String x = name+String.valueOf(i);
		               if(ITestResult.SUCCESS == result.getStatus())
		                 {
									ScreenShot.Capture_ScreenShot(driver, x);
		                 }
		          //     logger.info("Screenshot  captured");
		    }	
			
	@AfterTest
	 public void TearDown() 
	 {
		//logger=Logger.getLogger("Test_");
		//PropertyConfigurator.configure("log4l.properties");
		 driver.close();
		 report.flush();
		 //logger.info("browser closed");
	 }
}

	
	