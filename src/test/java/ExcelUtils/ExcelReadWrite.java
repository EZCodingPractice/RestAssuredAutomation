package ExcelUtils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * How to do Data-Driven testing using Excel file
 * Step 1: Add maven dependency for Excel reading and writing in pom.xml
 * Step 2: Create a folder and add Excel file and create data in the file
 * Step 3: Create a class and create functions to get row count from Excel file
 * Step 4: Create a function to get data from excel
 * Step 5: Create a constructor to get excelPath and sheetName
 * Step 6: Create a new class and call the Excel functions
 */

public class ExcelReadWrite {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelReadWrite(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }

    public void getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Object name = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        // Object subjectId = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum+1));
        System.out.println(name);
        // System.out.println(subjectId);

    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
}