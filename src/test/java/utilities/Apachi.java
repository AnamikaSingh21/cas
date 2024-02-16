package utilities;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.List;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class Apachi {
	      
		static List<WebElement>date;
		static List<WebElement>legends;
		WebDriver driver;
		public Apachi(WebDriver driver, List<WebElement> date, List<WebElement>legends) {
			this.driver=driver;
			this.date=date;
			this.legends=legends;
		}
		
	 
		//Writing data in excel file
		public static void writeData() throws IOException {
		 
		 FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src/main/resources\\testdat.xlsx");
		 
		 
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 
		 XSSFSheet sheet = workbook.createSheet();
		 {
		 
			 int c=0;
		 for(int i=0; i<date.size(); i++) {
			 
			 XSSFRow row = sheet.createRow(i);
			 if(i==0) {
                int j=0;
			  row.createCell(j).setCellValue("Dates ->"); 
			  c++;
			 }
			 else {
			 String s1= date.get(i).getText();
			 //String s2= legend.get(i).getText();
			 
			int j=0;
				 
				 row.createCell(j).setCellValue(s1);
				 c++;	 
		 }	
		 }
		 
		 for(int k=date.size(); k<legends.size(); k++) {
			
			 if(k==date.size()) {
				 XSSFRow row = sheet.createRow(c);
				 c++;
				 int j=0;
				 row.createCell(j).setCellValue("Legends -> ");
			 }
			 else {
			 if(k%2!=0) {
				 
			 XSSFRow row = sheet.createRow(c);
			 c++;
			 String s1= legends.get(k).getText();
			 
			int j=0;
				 row.createCell(j).setCellValue(s1);
			 }
			 
			 else {
				 continue;
			 }
			 
		 }
		 
		 
		 
		 }
		 
		 	
		}
		 workbook.write(file);
		 workbook.close();
		 file.close();
	}
	}






