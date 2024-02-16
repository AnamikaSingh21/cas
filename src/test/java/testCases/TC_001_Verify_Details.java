package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_Verify_Details extends BaseClass{

@Test(priority=1)
   public void verifyDetails() throws IOException  {
		HomePage ob=new HomePage(driver);
	    loger.debug("application logs...");
		String name2=p.getProperty("name1");
		String id2=p.getProperty("id1");
		
		
		ob.clickAccount();
		
		String name1=ob.name.getText();
		String id1=ob.id.getText();
		
		try {
		Assert.assertEquals(name1, name2, "Details are not matching");
		Assert.assertEquals(id1,id2,"Details are not matching");
		
	
		System.out.println(name1);
		System.out.println(id1);
		}
		
		catch(Exception e) {
			
			Assert.fail();
		}
		
		System.out.println();
		loger.info("Taking ScreenShot");
		ob.fullScreenShot1("homePage.png");
	}
}
