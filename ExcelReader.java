package excelUtility;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.Repo_Reader;
//class to read excel data
public class ExcelReader {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Repo_Reader repo;

	// constructor to read excel data
	public ExcelReader() throws IOException {
		repo = new Repo_Reader();

		String path = repo.getExcelPath();

		FileInputStream fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
	}
//method to get cell value in excel
	public String getData(int sheetnumber, int row, int col) {
		sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		//System.out.println(data);
		return data;
	}

	/*
	 * public int getRowCount(int sheetindex) { int rowcount =
	 * workbook.getSheetAt(sheetindex).getLastRowNum(); rowcount = rowcount + 1;
	 * return rowcount; }
	 */

}
