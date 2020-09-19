package com.actiTime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtils {
	
	/**
	 * This Method is used to verify the page title
	 * @param driver
	 * @param expectedTitle
	 */
	public static void verifyPageTitle(WebDriver driver,String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("The Expected Page is Dispalyed--->"+expectedTitle);
		}
		else
		{
			System.out.println("The Expected Page is not Dispalyed--->"+actualTitle);
		}
	}
	
	/**
	 * This Method is used to read the Data From Excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public static String read_XL_Data(String path,String sheet,int row,int cell) {
		
		String data = "";
		
		try {
			Workbook wb= WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}
	
	/**
	 * This Method is used to count number of Data Rows Present in Current Sheet
	 * @param sheet
	 * @return
	 */
	public static int read_XL_RowCount(String path,String sheet) {
		int data =0;
		
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheet).getLastRowNum();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void take_Screen_Shot(WebDriver driver,String path) {
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path);
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method is used to write Data into cell
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 */
	public static void set_XL_Data(String path,String sheet,int row,int cell,int data) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
			wb.write(new FileOutputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
