package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Sheet;
import org.osgl.xls.ExcelReader;

import BasePackage.TestBase;

import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addcustomer(String firstName , String LastName , String Postcode) {

	}

	@DataProvider
	public Object[][] getData()
	{

		 String sheetName = "AddCustomerTest";
	        int rows = ((Object)excel).getRowCount(sheetName);
	        int cols = ((org.osgl.xls.ExcelReader)excel).getColumnCount(sheetName);

	        Object[][] data = new Object[rows - 1][cols];

	        for (int rowNum = 2; rowNum <= rows; rowNum++) {
	            for (int colNum = 0; colNum < cols; colNum++) {
	                data[rowNum - 2][colNum] = ((org.osgl.xls.ExcelReader)excel).getCellData(sheetName, rowNum, colNum);
			}

		}

		return data;

		
	}
