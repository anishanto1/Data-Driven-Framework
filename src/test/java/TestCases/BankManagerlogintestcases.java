package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.TestBase;

public class BankManagerlogintestcases extends TestBase

{
    @Test
	public void loginasBankManager() throws InterruptedException {
    	
    	//PropertyConfigurator.configure("log4j.properties");
    	log.info("Inside Login Testcase");
		driver.findElement(By.cssSelector(objectRepository.getProperty("BankManagerLoginButton"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(IsElementPresent(By.cssSelector(objectRepository.getProperty("Addcustomer"))));
		log.info("Login successfully Executed");
	}
	
	
	
}
