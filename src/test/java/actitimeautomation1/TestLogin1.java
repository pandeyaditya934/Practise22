package actitimeautomation1;

import actitimeautomation.imp1.Pages2.LoginPage;
import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.CommonUtil;
import actitimeautomation.imp1.common.PropertyHandling;
import actitimeautomationPractise.ExelHandle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*public class TestLogin1 extends BaseClass {
    PropertyHandling propertyHandling;
    CommonUtil commonUtil;
    WebDriver driver;
    ExelHandle exelHandle;
    Workbook workbook;
    LoginPage loginPage;

    @BeforeClass
    public void launcher() throws IOException {
        propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver=super.driver;
        driver.navigate().to(propertyHandling.getProperty("actitimeURL"));
        commonUtil=new CommonUtil(driver);
        exelHandle=new ExelHandle();
        loginPage=new LoginPage(driver);
    }
    /* public Object[][] getTestdata()
    {   Object[][] obj=new Object[][]
            {   {"Cybercheck2"}
            };
        return obj;
    }
    @DataProvider
    public Object[][] datas() throws IOException {    String filepath="E:\\TestData1.xlsx";
        String extention=filepath.substring(filepath.indexOf(".")+1);
        FileInputStream fileInputStream=new FileInputStream(filepath);
        if(extention.equals("xlsx"))
        {   workbook=new XSSFWorkbook(fileInputStream);
        }else { workbook=new HSSFWorkbook(fileInputStream);//we create workbook here
        }
        Sheet sheet=workbook.getSheet("Sheet1");//we create sheet here
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
                {   /* double val=cell.getNumericCellValue();//covert the value ito the respetive variable and store into the value of object.
                    int valuess=(int)Math.round(val);
                    value=valuess;
                    value=(int)Math.round(cell.getNumericCellValue());//above three line represent the mechanism of this line.
                } else {value="";}
                testdata[i-1][j]=value;
            }
        }return testdata;
    }
    @Test(dataProvider = "datas")
    public void loginmechanis1(Object username, Object password) throws InterruptedException
    {   loginPage.loginmechanism(username, password);
    }




}*/
