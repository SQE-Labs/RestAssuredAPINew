package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;


public class ReadExcelFile {
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName,String sheetName,int rowNo,int cellNo) {
		
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
		    //System.out.println(cell.getCellType());
			switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
			case NUMERIC:
				//System.out.println(String.format("%.0f", cell.getNumericCellValue()));
				//System.out.println((String.valueOf(cell.getNumericCellValue())).split("/.")[0]);
               return String.format("%.0f", cell.getNumericCellValue());
               
            
            default:
                return "Unknown Cell Type";
        }
			
		}
		catch(IOException e) {
			e.printStackTrace();
			return cell.getStringCellValue();
		}
		
		
		
	}
	
	
	public static int getRowCount(String fileName,String sheetName) {
		
	
		
		try {
			inputStream = new FileInputStream(fileName);
			
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			int ttlRows = excelSheet.getLastRowNum() + 1;
			workBook.close();
			return ttlRows;
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
			return 0;
		}
			
		
	}
	
	
	public static int getcolcount(String fileName,String sheetName) {
		
		
		try {
		FileInputStream	fileInputStream = new FileInputStream(fileName);
		XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
		XSSFSheet excelSheet = workBook.getSheet(sheetName);
		int ttlCells = excelSheet.getRow(0).getLastCellNum();
		return ttlCells;
		}
		catch(IOException e) {
			e.printStackTrace();
			return 0;
		}
			
	}
	
}
