package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Truetime;
import testBase.BaseClass;

public class TC_002_OneCogVerification extends TC_001_Verify_Details {

	
	@Test(priority=2, dependsOnMethods= {"verifyDetails()"})
	public void verify_Truetime() throws InterruptedException, IOException {
		HomePage obj = new HomePage(driver);
		loger.info("__Starting TC_001_Truetime__");

		
		loger.info("one Cognizant validation");
		obj.verifyOnCog();
		
		System.out.println();
		
		loger.info("one cognizant click");
		String s = obj.clickOncog1();
		
		
		loger.info("Switching Window");
		obj.switchWindow(s);
		
		
	}
}
