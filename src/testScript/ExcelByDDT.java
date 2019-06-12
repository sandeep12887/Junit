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

public class ExcelByDDT {

	public WebDriver driver;

	public static void fulldata() throws Throwable {
		File f = new File("C:\\Users\\admin\\Desktop\\Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sheet = wb.getSheet("Sheet1");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				if (cell.getCellType().equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				if (cell.getCellType().equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
				}
			}

		}

	}

	public static String particularcell(int rownum, int cellnum) throws Exception {
		File f = new File("C:\\Users\\admin\\Desktop\\Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sheet = wb.getSheet("Sheet1");
		String valueOf1="";
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		Cell cell = sheet.getRow(rownum).getCell(cellnum);
		if (cell.getCellType().equals(CellType.STRING)) {
			cell.getStringCellValue();
		}
		if (cell.getCellType().equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			 valueOf1 = String.valueOf(l);
		}
		return valueOf1;

	}

	public static void main(String[] args) throws Throwable {
		fulldata();
		String particularcell=particularcell(1, 1);
		String particularcell1=particularcell(1, 2);
		
		
		
	}

}
