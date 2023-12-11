package Utils;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	public static final int ImplicitWaitTime=10;
	

	public static String getTimeStamp() {
		Date date=new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		//System.out.println(timeStamp);
		return "vikram"+timeStamp+"gmail.com";
		

	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) throws Exception {
		
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testData.xlsx");
		//System.out.println(file);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workBook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		//XSSFRow row = sheet.getRow(ImplicitWaitTime);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rows][cols];
		
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				 CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					
					break;

				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					
					break;
				}
			}
		}
		return data;
	}
	
	public static void main(String[] args) throws Throwable {
		getTestDataFromExcel("Login");
	}

}
