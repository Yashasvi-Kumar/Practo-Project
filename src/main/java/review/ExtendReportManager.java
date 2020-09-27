package review;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtendReportManager {
	//public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		if(  report==null) {
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Output/report.html");
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("os", "windows 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Browser", "chrome");
			
			htmlReporter.config().setDocumentTitle("UAT automation results");
			htmlReporter.config().setReportName("UI test reports");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd,yyy HH:mm:ss");
			
		}
		return report;
	}

}
