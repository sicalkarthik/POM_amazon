package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DP {
	public static String[][] getData(String Excel) throws FileNotFoundException, IOException {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("./testData/" + Excel + ".xlsx"));
		XSSFSheet sheet=wb.getSheetAt(0);
		int rc=sheet.getLastRowNum(); 	System.out.println(rc);
		int cc=sheet.getRow(0).getLastCellNum(); 	System.out.println(cc);
		String[][] testData=new String[rc][cc];
		for(int i=1;i<=rc;i++){
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<cc;j++){
				testData[i-1][j]=row.getCell(j).getStringCellValue();
			}
		}
		return testData;
	}
}
