package com.mindtree.Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public String getData(int sheetNum, int rownum, int col) {
		String data = "";
		FileInputStream stream;
		try {
			stream = new FileInputStream("TestData\\TestData.xlsx");

			Workbook workbook = WorkbookFactory.create(stream);
			Sheet s = workbook.getSheetAt(sheetNum);
			data = s.getRow(rownum).getCell(col).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
