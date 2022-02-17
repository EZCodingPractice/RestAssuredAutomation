package ExcelUtils;

public class ExcelUtilsTest {

    public static void main(String[] args) {

        String excelPath = "src/test/resources/data.xlsx";
        String sheetName = "Sheet1";

        ExcelReadWrite excel = new ExcelReadWrite(excelPath, sheetName);

        int rowCount = excel.getRowCount();

        for(int rowNum = 1; rowNum < rowCount; rowNum++) {
            for(int colNum = 0; colNum <=1; colNum++) {
                excel.getCellData(rowNum, colNum);
            }

        }

        System.out.println();
        ExcelRW excelSheet = new ExcelRW(excelPath, sheetName);

        int sheetRowCount = excelSheet.getSheetRowCount();

        for(int rowNum = 1; rowNum < sheetRowCount; rowNum++) {
            for(int colNum = 0; colNum <= 1; colNum++) {
                excelSheet.getSheetCellData(rowNum, colNum);
            }
        }


    }

}
