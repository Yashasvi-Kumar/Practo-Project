package review;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logs {
	private static Logger logger;

	public static void logName(String name) {
		logger = Logger.getLogger(name);
		 PropertyConfigurator.configure("C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\log4j.properties");
	}


	public static void logInfo(String info) {
		logger.info(info);
	}
	
	public static void startTestCase() {
		logger.info("***********************************");
		logger.info("New Test Case");
		logger.info("***********************************");
	}
	
	public static void endTestCase() {
		logger.info("***********************************");
		logger.info("Test Case Ends");
		logger.info("***********************************");
	}
	
	public static void errorMessage(String error) {
		logger.error(error);
	}
}
