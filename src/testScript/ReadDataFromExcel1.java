package testScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ReadDataFromExcel1{
	public static WebDriver driver;

	public static void excel1()throws Throwable {

		File f = new File("D:\\DataDrive.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("Sheet1");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
		
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			System.out.println(physicalNumberOfCells);
			
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				
				if (cell.getCellType().equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);

				}

			}

		}

	}
           public static String excel2(int rownum, int cellnum) throws Exception {
        	File f1 = new File("D:\\\\DataDrive.xlsx");
       		FileInputStream fin1 = new FileInputStream(f1);
       		Workbook wb1 = new XSSFWorkbook(fin1);
       		Sheet sheet = wb1.getSheet("Sheet1");	
       		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
       		//System.out.println(physicalNumberOfRows);	
       		String stringCellValue1="";
       		Cell cell=sheet.getRow(rownum).getCell(cellnum);
       		if (cell.getCellType().equals(CellType.STRING)) {
				 stringCellValue1= cell.getStringCellValue();				
       		}
       		if (cell.getCellType().equals(CellType.NUMERIC)) {
    			double numericCellValue = cell.getNumericCellValue();
    			long l=(long)numericCellValue;
				 stringCellValue1=String.valueOf(1);				
   		}
			
       		return stringCellValue1;
}
           public static void main(String[] args) throws Throwable {
        	   String excel2 = excel2(1, 1);
        	   //String excel3 = excel2(1, 2);
        	  System.out.println(excel2);
        	  //excel1();
              System.setProperty("webdriver.chrome.driver","C:\\Users\\abc\\eclipse-workspace\\MavenPractice\\Driver\\chromedriver.exe" );
       		WebDriver driver=new ChromeDriver();
       		driver.get("https://lingscommunity.force.com/#/");
       		driver.manage().window().maximize();
       		Thread.sleep(3000);
       		WebElement redeem = driver.findElement(By.xpath("//a[@href='#/de/gutschein-einlosen']"));
       		redeem.click();
       		Thread.sleep(3000);
       		
       		
       		WebElement login = driver.findElement(By.id("username"));
       		
       		login.sendKeys(excel2);
       		
        	   
        	
        	  // driver.get("https://lingscommunity.force.com/#/");
        	   
        	   
        	
			
		}
}
    
