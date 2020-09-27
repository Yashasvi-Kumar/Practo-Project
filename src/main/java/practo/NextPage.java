package practo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class NextPage {
	WebDriver driver;
	String Name[] = new String[50];
	String Rating[] = new String[50];

	public NextPage(WebDriver dr) {
		// TODO Auto-generated constructor stub
		this.driver = dr;
	}

	public void Open_24x7() {
		WebElement Open_24x7 = driver
				.findElement(By.xpath("//body//div[@id='container']//div//div[3]//label[1]//div[1]"));
		Open_24x7.click();

		Reporter.log("---Open_24X7 CheckBox Clicked", true);
	}

	public void All_Filters() {
		try {
			WebElement All_Filters = driver.findElement(By.xpath("//span[contains(text(),'All Filters')]"));
			All_Filters.click();
		} catch (Exception e) {
			WebElement All_Filters = driver.findElement(By.xpath("//span[contains(text(),'All Filters')]"));
			All_Filters.click();
		}
		Reporter.log("---All Filters DropDown Clicked", true);
	}

	public void Sub_Filter_Has_Parking() {
		WebElement Has_Parking = driver
				.findElement(By.xpath("//div[@class='c-filter__bottom expanded']//label[1]//div[1]"));
		Has_Parking.click();

		Reporter.log("---Has Parking CheckBox Clicked", true);
	}

	public void Get_Hospital() {
		int count = 0;
		String Name[] = null;
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int index = 2;
			while (count < 5) {
				String rating = driver
						.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[3]/div[" + index
								+ "]/div/div[1]/div[2]/div/div[1]/div/div/span[1]"))
						.getText();
				if (Float.parseFloat(rating) > 3.5) {
					Name[count] = driver
							.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[3]/div["
									+ index + "]/div/div[1]/div[1]/div/div[2]/div/a/h2"))
							.getText();
					count++;
				}
				index++;
			}
		} catch (Exception e) {
			if (count == 0) {
				System.out.println("No Hospital Found");
			} else {
				System.out.println("There were only " + count + " hospitals.");
			}

			Reporter.log("---Hospitals Searched and Names Fetched", true);
		}
	}

	public void Excel_Output_Sheet() throws Exception {
		try {
			File file = new File("C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\List of Hospitals.xlsx");
			XSSFWorkbook one = new XSSFWorkbook();
			XSSFSheet sheetOne = one.createSheet("Names");
			int Size = Name.length;
			for (int i = 0; i < Size; i++) {
				XSSFRow row = sheetOne.createRow(i);
				row.createCell(0).setCellValue(Name[i]);
				FileOutputStream fileOut = new FileOutputStream(
						"C:\\Users\\Satan 01\\eclipse-workspace\\ReviewProject\\List of Hospitals.xlsx");
				one.write(fileOut);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Reporter.log("Fetched Data Stored To The Excel File", true);
	}

}
