package auto.tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver2Test {

  private WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\arthy\\Downloads\\selenium_downloads\\chromedriver_win32\\chromedriver.exe"); 
      driver = new ChromeDriver();
      
  }
	  
  @Test
  public void WebDriver1Test() {
	  driver.get("http://www.amazon.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}