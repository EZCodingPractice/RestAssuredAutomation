package ExcelUtils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelRW {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelRW(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getSheetCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Object cellContent = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(cellContent);
    }

    public int getSheetRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

}
