package actitimeautomation.imp1.common;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling2 {
    Workbook workbook;
    public Object[][] dataFromExcel(String filePath, String sheetname) throws IOException {
        String extention=filePath.substring(filePath.indexOf(".") + 1);
        FileInputStream fileInputStream=new FileInputStream(filePath);
        if (extention.equals("xlsx"))
        {  workbook = new XSSFWorkbook(fileInputStream);
        } else if (extention.equals("xlx")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }
        Sheet sheet=workbook.getSheet(sheetname);
        int totalRow=sheet.getPhysicalNumberOfRows();
        int totalColumn=sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] exceldata = null;
        for (int i=1; i<=totalRow-1;i++)
        {
            Row row=sheet.getRow(i);
            for (int j=0;j<=totalColumn-1;j++)
            {   Cell cell=row.getCell(j);
                CellType cellType = cell.getCellType();
                Object value=null;
                 exceldata=new Object[totalRow-1][totalColumn];
                if (cellType.equals(CellType.NUMERIC)) {
                    value = cell.getNumericCellValue();
                } else if (cellType.equals(CellType.STRING)) {
                    value = cell.getStringCellValue();
                } else if (cellType.equals(CellType.BOOLEAN)) {
                    value = cell.getBooleanCellValue();
                } else {
                    value = " ";
                }
                exceldata[i-1][j]=value;
            }
        }workbook.close();
        return exceldata;
    }
}
