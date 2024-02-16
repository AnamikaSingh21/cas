package pageObject;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Apachi;

public class Truetime extends BasePage {

	
	
	public Truetime(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id=\"oneC_searchAutoComplete\"]")
	WebElement search;

	@FindBy(xpath="//div[@class='appsResultText' and text()='TruTime ']")
	WebElement trt;
	

	@FindBy(xpath="//a[@class='nav-link active']")
	WebElement trt1;
	
	@FindBy(xpath="//div[@class='dayDetail ng-scope']/div[@class='dayHeadr active ng-binding ng-scope' or @class='dayHeadr ng-binding ng-scope']")
	public List<WebElement> date;
	
	@FindBy(xpath="//ul[@class=\"legend-labels\"]/li")
	public List<WebElement> legends;
	
	@FindBy(xpath="//div[@class=\"dayHeadr active ng-binding ng-scope\"]")
	WebElement color;
	
	@FindBy(xpath="//div[@class=\"dayDetail ng-scope\"]")
	WebElement backcolor;
	
	@FindBy(xpath="//span[text()=\"January\" and @class=\"ui-datepicker-month\" ]")
	WebElement month;
	
	@FindBy(xpath="//span[text()=\"2024\" and @class=\"ui-datepicker-year\" ]")
	WebElement year;
	
	public String m1="";

	public String m2="";

    public String y1="";

    public String y2="";
	
	
	public void searchh(String s) {
		search.click();
		search.sendKeys(s);
	}
	
	public void switchToFrame() {
		driver.switchTo().frame("appFrame");
	}
	
	public void TrutimeClick() throws InterruptedException {
		Thread.sleep(2000);
		trt.click();
	}
	
	public void verifyTrutime() {
		 boolean d=trt1.isDisplayed();
		 String e=trt1.getText();
		    
		    if(d==true) {
		 
		    	System.out.println(e+" "+"is displayed");
		    }
		    else {
		    	System.out.println(e+" "+"is not displayed");
		    }
	}
	
	public void verifyDates() {
		
		for(int i=0; i<date.size(); i++) {
			   String s2=date.get(i).getText();
			   boolean s1=date.get(i).isDisplayed();
			   
			   if(s1==true) {
				  
				   System.out.println(s2+" "+"is displayed");
			   }
			   else {
				   System.out.println(s2+" "+"is not displayed");
			   }
		   }
	}
	
	public void printLegends() {
		 for(int j=0; j<legends.size(); j++) {
			   if(j%2==0) {
				  continue; 
			   }
			   
			   else {
				   String h=legends.get(j).getText();
				 System.out.print(h+" ");
			   }
		   }
	}
	
	public void verifyHighlight() {
		
		String color1=color.getCssValue("color");
		String backcolor1=backcolor.getCssValue("background-color");
		
		
		
		if(!color1.equals(backcolor1)){
		   	System.out.println("Text is not highlighted!");
		   }
		   else{
		   	System.out.println("Text is highlighted!");
		   }
	}
	
	public boolean getCurrentDate() {
		 LocalDate currentDate = LocalDate.now();
		    Month ms = currentDate.getMonth();
		    m1=ms.toString();
		    int currentYear= currentDate.getYear();
		    y1=Integer.toString(currentYear);
		    
		    String m=month.getText();
			m2=m.toUpperCase();
			y2=year.getText();
			 
			if(m1.equals(m2) && y1.equals(y2)) {
				System.out.println();
			
				return true;
			}
			
			else {
				
				return false;
			}
		    
	}

	
   public void LastDateOfTruTime() {
	     LocalDate date1 = LocalDate.now().minusDays(15);
		 
		  Month m3=date1.getMonth();
		  int d1=date1.getDayOfMonth();
		  int y3=date1.getYear();
		  
		  System.out.println("Last TopUp date is:"+ " "+d1+" "+m3+" "+y3);
   }
	
	
	
		public  void fullScreenShot1(String v) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File trg= new File("C:\\Users\\2303494\\eclipse-workspace\\cas\\screenShots\\"+v);
			FileUtils.copyFile(src, trg);
		}
	
	public void constructorApachi() {
		Apachi ob= new Apachi(driver,date,legends);
	}
	
}
