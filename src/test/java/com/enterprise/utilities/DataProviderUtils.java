package com.enterprise.utilities;
import org.testng.annotations.DataProvider;


public class DataProviderUtils {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {

	    ExcelUtils excel = new ExcelUtils(
	            "src/test/resources/TestData.xlsx",
	            "LoginData");
	    
	    int rowCount = excel.getRowCount();
	    
	    Object[][] data = new Object[rowCount - 1][3];
	   
	    
	    for (int i = 1; i < rowCount; i++) {

	        data[i - 1][0] = excel.getCellData(i, 0);

	        data[i - 1][1] = excel.getCellData(i, 1);

	        data[i - 1][2] = excel.getCellData(i, 2);

	    } 

	    excel.closeWorkbook();

	    return data;

	}
	
}
