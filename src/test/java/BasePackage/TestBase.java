package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.osgl.xls.ExcelReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// Using TestBase ( Super Class )  Mainly for -  Webdriver , Properties , logs , Extent Reports , DB , Excel ,Mail

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static	Properties objectRepository = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Excel/testdata.xlsx"));


	@BeforeSuite 
	public void setup() {

		if(driver == null)
		{

			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//Config.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//ObjectRepository.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				objectRepository.load(fis);
				log.debug("ObjectRepository file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			config.getProperty("browser").equals("chrome");
			log.debug("chrome launched");

		}
		driver.get(config.getProperty("testsiteURL"));
		log.debug("Navigated to : " + "config.getProperty(\"testsiteURL\")");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
	}


	public boolean IsElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public TestBase() {
	    try {
	        excel = new ExcelReader(new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Excel/testdata.xlsx"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	@AfterSuite // It will execute when all the testcases has been executed 
	public void teardown() {

		if (driver!=null) {
			driver.quit();	
		}
		log.debug("Test execution Completed");
	}

}
