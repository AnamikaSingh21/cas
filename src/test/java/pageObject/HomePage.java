package pageObject;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//div[@id='O365_MainLink_MePhoto']")
	WebElement acount;
	
	@FindBy(xpath="//div[@id=\"mectrl_currentAccount_primary\"]")
	public WebElement name;
	
	@FindBy(xpath="//div[@id=\"mectrl_currentAccount_secondary\"]")
	public
	WebElement id;
	
	@FindBy(xpath="//div[@title=\"OneCognizant\"]")
	WebElement oncog;
	
	
	public void clickAccount() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ele = myWait.until(ExpectedConditions.visibilityOf(acount));
		ele.click();
	}
	
	public void verifyDetails(String n, String i) {
		String name1=name.getText();
		String id1=id.getText();
		
		if(name1.equals(n) && id1.equals(i)) {
		System.out.println(name1);
		System.out.println(id1);
		}
		
		else {
			System.out.println("Not Displayed");
		}
	}
	
	public void verifyOnCog() {
		boolean b=oncog.isDisplayed();
		
		if(b==true) {
			System.out.println("One Cognizant is Displayed");
		}
		else {
			System.out.println("One Cognizant is not Displayed");
		}
	}
	//public String s = "";
	 public String clickOncog1() throws InterruptedException {
		
		 String s=driver.getWindowHandle();
		// System.out.println(s+" "+"done");
		  oncog.click();
		  return s;
	 }
		
	 public void switchWindow(String s) {
		    
 
		    //System.out.println(s);
			Set<String> windHandle= driver.getWindowHandles();
		   
			String child="";
			for(String str : windHandle) {
				if(!str.equals(s)) {
					child = str;
				}
			}
		
		    driver.switchTo().window(child);
		}

	 public  void fullScreenShot1(String v) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File trg= new File("C:\\Users\\2303494\\eclipse-workspace\\cas\\screenShots\\"+v);
			FileUtils.copyFile(src, trg);
		}
	
}
