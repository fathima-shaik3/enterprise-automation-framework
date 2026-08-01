package com.enterprise.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtils {

	private Workbook workbook;
	private Sheet sheet;
	private DataFormatter formatter = new DataFormatter();
	
	public ExcelUtils(String filePath, String sheetName) {

	    try {

	        FileInputStream fis = new FileInputStream(filePath);

	        workbook = new XSSFWorkbook(fis);

	        sheet = workbook.getSheet(sheetName);

	    } catch (IOException e) {

	        e.printStackTrace();

	    }
	}
	public int getRowCount() {

	    return sheet.getPhysicalNumberOfRows();

	}
	public String getCellData(int rowNum, int colNum) {

	    Row row = sheet.getRow(rowNum);

	    if (row == null) {
	        return "";
	    }

	    if (row.getCell(colNum) == null) {
	        return "";
	    }

	    return formatter.formatCellValue(row.getCell(colNum));

	}
	
	public void closeWorkbook() {

	    try {

	        workbook.close();

	    } catch (IOException e) {

	        e.printStackTrace();

	    }

	}
}
