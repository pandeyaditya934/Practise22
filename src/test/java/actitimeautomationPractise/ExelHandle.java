package actitimeautomationPractise;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExelHandle {
    @Test
    public Object[][] getExceldata() throws IOException {
        Workbook workbook=null;
        String filepath="E:\\TestData2.xlsx";
        String extention=filepath.substring(filepath.indexOf(".")+1);
        FileInputStream fileInputStream=new FileInputStream(filepath);
        if(extention.equals("xlsx"))
        {   workbook=new XSSFWorkbook(fileInputStream);
        }else { workbook=new HSSFWorkbook(fileInputStream);//we create workbook here
        }
        Sheet sheet=workbook.getSheet("Sheet2");//we create sheet here
        int totalrows=sheet.getPhysicalNumberOfRows();//number of rows
        int totalcolumns=sheet.getRow(0).getPhysicalNumberOfCells();//number of columns
        Object[][] testdata =new Object[totalrows][totalcolumns];//create an object of multidimentional to store the data from the excel
        Object value=null;
        for (int i= 1;i<=totalrows-1;i++)
        {   Row row=sheet.getRow(i);
            for (int j=0;j<=totalcolumns-1;j++)
            {   Cell cell=row.getCell(j);
                CellType cellType=cell.getCellType();
                if(cellType.equals(CellType.STRING))
                {   value=cell.getStringCellValue();
                } else if (cellType.equals(CellType.NUMERIC))
                {   value=cell.getNumericCellValue();//covert the value ito the respetive variable and store into the value of object.
                }else {value="";}
                testdata[i-1][j]=value;
            }System.out.println();
        }System.out.println(testdata);//from here we convert data into the single string
        /*for(int i=0;i<=testdata.length;i++)
        {   String username=testdata[i][0].toString();
            String pasword=testdata[i][1].toString();
            String nothing=testdata[i][2].toString();
            System.out.println(username+" "+pasword+" "+nothing);
        }*/

        workbook.close();
        fileInputStream.close();
        return testdata;
    }
}
