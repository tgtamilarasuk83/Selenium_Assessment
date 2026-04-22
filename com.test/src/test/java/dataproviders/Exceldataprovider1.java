package dataproviders;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exceldataprovider1 {
@DataProvider(name = "excel" ,parallel = true )
   public  String[][]  getdata() throws IOException {
	  File excelfile = new File("src/test/resources/excel/data_excel.xlsx");
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
