package com.learn.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel_Data_Provider {
	
	HSSFWorkbook wb;
	
	public Excel_Data_Provider() 
	{
		File src = new File("/home/anbu/eclipse-workspace/Selenium_Framework/TestData/Input_Data.xls");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			wb = new HSSFWorkbook(fis);
			}  
		catch (Exception e) {
			
			System.out.println("Unable to read Excel File "+e.getMessage());
			
			}		
	}
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public String getStringData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

}
