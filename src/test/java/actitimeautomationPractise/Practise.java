package actitimeautomationPractise;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Practise {

    @Test
    public void excelHandel() throws IOException {
        Object[] obb=new Object[1];
        obb[0]="Aditya";
        obb[1]="Pandey";
        Object[] slam=obb;
        System.out.print(slam[0]);
    }
}
