package utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderQAfox {

    @DataProvider(name = "excel_qafox" ,  parallel = true)
    public String[][] getData() throws IOException {

        File excelFile = new File("src/main/resources/excel/QA_Fox_dataProvider.xlsx");
        System.out.println("File exists: " + excelFile.exists());

        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(1);

        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rows - 1][columns];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rows; i++) {

            if (sheet.getRow(i) == null) continue; 

            for (int j = 0; j < columns; j++) {

                if (sheet.getRow(i).getCell(j) == null) {
                    data[i - 1][j] = "";
                } else {
                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }

                System.out.print(data[i - 1][j] + " | ");
            }
            System.out.println();
        }

        System.out.println(Arrays.deepToString(data));

        workbook.close();
        fis.close();

        return data;
    }
}
