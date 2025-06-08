package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount - 1][colCount];
            for (int i = 1; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    data[i - 1][j] = cell.toString();
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
