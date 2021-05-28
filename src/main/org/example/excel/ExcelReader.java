package org.example.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    private final String filePath;
    private final int sheetIndex;

    public ExcelReader(String filePath, int sheetIndex) {
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
    }

    private XSSFSheet getSheet() throws Exception{
        FileInputStream fileInputStream= new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook= new XSSFWorkbook(fileInputStream);
        return xssfWorkbook.getSheetAt(sheetIndex);
    }

    public String getCellValueAsString(Cell cell){
        String cellValue;
        switch (cell.getCellType()){
            case NUMERIC:
                cellValue= String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue= cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue= cell.getCellFormula();
            case BLANK:
                cellValue="BLANK";
            default:
                cellValue ="DEFAULT";
        }
        return cellValue;
    }

    public Map<String, Map<String, String>> getExcelAsMap() throws Exception{
        XSSFSheet xssfSheet= getSheet();
        Map<String, Map<String, String>> completeSheetData = new HashMap<>();
        Map<String,String> singleRowData= new HashMap<>();
        List<String> columnHeader= new ArrayList<>();
        Row row= xssfSheet.getRow(0);
        row.forEach(x ->
                columnHeader.add(x.getStringCellValue()));
        int rowCount= xssfSheet.getLastRowNum();
        int columnCount= row.getLastCellNum();

        for(int i=1; i<=rowCount;i++){
            Row row1= xssfSheet.getRow(i);
            for(int j=0;j<columnCount;j++){
                Cell cell= row1.getCell(j);
                singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
            }
            completeSheetData.put(String.valueOf(i), singleRowData);
        }
        return completeSheetData;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ExcelReader(System.getProperty("user.dir"),0).getExcelAsMap());
    }
    //Output:
}
