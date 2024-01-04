package org.bas;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}

	public static void windowmaximize() {
		driver.manage().window().maximize();

	}

	public static void launchurl(String url) {
		driver.get(url);


	}

	public static String pagetitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageurl() {
		String Url = driver.getCurrentUrl();
		return Url;
		}

	public static void passtext(String text, WebElement ele) {
		ele.sendKeys(text);

	}

	public static void closebrowser() {

		driver.quit();
	}

	public static void clikbtn(WebElement ele) {
		ele.click();

	}

	public static void screenshot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ imgName.png");
		FileUtils.copyFile(image, f);

	}

	public static Actions a;

	public static void movethecursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
		;

	}

	public static void dragdrop(WebElement dragWebElement, WebElement dropWebElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropWebElement);

	}

	public static JavascriptExecutor js;

	public static void scrollthepage(WebElement tarWebele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebele);

	}

	public static void excelread(String sheetName, int rownum, int cellnum) throws IOException {
		File f = new File("C:\\Users\\annie\\eclipse-workspace\\Worked\\Excel\\sam.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("end");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();

		String value = " ";
		if (cellType == 1) {
			String stringCellValue = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			s.format(dateCellValue);

		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			String of = String.valueOf(l);
		}

	}

	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\annie\\eclipse-workspace\\Worked\\Excel\\sam.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("end");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}

	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\annie\\eclipse-workspace\\Worked\\Excel\\sam.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("end");
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\annie\\eclipse-workspace\\Worked\\Excel\\sam.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("end");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updatedatatoparticularcell(int getrow, int getcell, String existingdata, String newdata)
			throws IOException {
		File f = new File(newdata);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("end");
		Row row = sheet.getRow(getcell);
		Cell cell = row.getCell(getcell);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(stringCellValue)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}


}
