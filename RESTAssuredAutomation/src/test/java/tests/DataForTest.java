package tests;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class DataForTest {

	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {

		String excelPath = "./data/DataTest.xlsx";
		String sheetName = "Sheet1";

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int row = excel.getRowCount() - 1;

		Object[][] data = new Object[row][2];

		for (int i = 0; i < row; i++) {
			data[i][0] = excel.getCellData(i + 1, 0);
			data[i][1] = excel.getCellData(i + 1, 1);
		}
		return data;
	}

}
