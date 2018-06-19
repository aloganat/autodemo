package auto.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WebDriver1Test {

  private WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\arthy\\Downloads\\selenium_downloads\\chromedriver_win32\\chromedriver.exe"); 
      driver = new ChromeDriver();
      
  }
	  
  @Test(dataProvider = "UrlName")
  public void WebDriver1Test(String url, String path) throws InterruptedException {
	  System.out.println(url);
	  System.out.println(path);
	  System.out.println(System.getProperty("environment"));
	  driver.get(url);
	  Thread.sleep(1000);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @DataProvider(name = "UrlName")
  public Object[][] browsern() {
      String inputfile = System.getProperty("environment");
	  Object[][] arrayObject = getExcelData(inputfile,"Sheet1");
	  //System.out.println(arrayObject);
	  //Object[][] arrayObject1 = {{"chrome","path"}};
	  return arrayObject;
 
  }
  
  public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					System.out.println(sh.getCell(j, i).getContents());
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
  

}
