package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	public static void main(String args[]) {
		Properties prop=new Properties();
		InputStream readFile=null;
		try {
			readFile=new FileInputStream("C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\src\\main\\java\\review\\config.properties");
			prop.load(readFile);
			System.out.println(prop.getProperty("Browser"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(readFile!=null) {
				try {
					readFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}