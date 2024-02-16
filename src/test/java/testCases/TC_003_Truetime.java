package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Apachi;
import pageObject.HomePage;
import pageObject.Truetime;


 
public class TC_003_Truetime extends TC_002_OneCogVerification {
	@Test(priority=3, dependsOnMethods= {"verifyDetails()","verify_Truetime()"})
	public void verify_Truetimee() throws InterruptedException, IOException {
		
	
		
		Truetime obj2= new Truetime(driver);
		
		
		loger.info("tru time search");
		obj2.searchh(p.getProperty("trt"));
		
		loger.info("tru time click");
		obj2.TrutimeClick();
		
		loger.info("Taking ScreenShot");
		obj2.fullScreenShot1("OneCog.png");
		
		loger.info("Switching Frame");
		obj2.switchToFrame();
		
		loger.info("Tru time validation");
		obj2.verifyTrutime();
		
		System.out.println();
		
		loger.info("Dates validation");
		obj2.verifyDates();
		
		System.out.println();
		
		loger.info("Highlight validation");
		obj2.verifyHighlight();
		
		System.out.println();
		
		loger.info("Printing Legends");
		obj2.printLegends();
		
		System.out.println();
		
		loger.info("validating current Date");
		boolean b=obj2.getCurrentDate();
		
		try {
		Assert.assertTrue(b);
		
		System.out.println("current month and year : "+obj2.m1+" "+obj2.y1);
		System.out.println("month and year displayed : "+obj2.m2+" "+obj2.y2);
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		System.out.println();
		
		loger.info("validating last Date Of Truetime Topup");
		obj2.LastDateOfTruTime();
		
		
		loger.info("screenShot of Tru Time");
		obj2.fullScreenShot1("trutime.png");
		
		loger.info("Writing data in Apachi");
		obj2.constructorApachi();
		utilities.Apachi a=new utilities.Apachi(driver,obj2.date, obj2.legends);
		a.writeData();
		
		loger.info("__Finishing TC_002_Truetime__");
		
	}
}



