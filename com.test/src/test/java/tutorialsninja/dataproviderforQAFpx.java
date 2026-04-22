package tutorialsninja;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderforQAFpx {
@DataProvider(name = "excel_qafox"  )
   public  String[][]  getdata() throws IOException {
	   File excelfile = new File("src/test/resources/excel/QA_Fox_dataProvider.xlsx");

	  System.out.println(excelfile.exists());
	  
	  FileInputStream FIS = new FileInputStream(excelfile);
	  XSSFWorkbook  workbook = new XSSFWorkbook(FIS);
	  XSSFSheet sheet  = workbook.getSheetAt(0);
	 int rows =  sheet.getPhysicalNumberOfRows(); 
	 int colomns =   sheet.getRow(0).getLastCellNum();
	  
	 String array[][] = new String[rows - 1][colomns];

	 for (int i = 1; i < rows; i++) {  
	     for (int j = 0; j < colomns; j++) {
	         DataFormatter formate = new DataFormatter();
	         array[i - 1][j] = formate.formatCellValue(sheet.getRow(i).getCell(j));
	         System.out.println(sheet.getRow(i).getCell(j).getRichStringCellValue());
	     }
	 }
	 
	

	 System.out.println(Arrays.deepToString(array));


	  workbook.close();
	  FIS.close();
	  
	  return array;
  }

}