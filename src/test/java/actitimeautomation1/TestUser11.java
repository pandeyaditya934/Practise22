package actitimeautomation1;

import actitimeautomation.imp1.Pages2.LoginPage;
import actitimeautomation.imp1.Pages2.UserTestPage;
import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.ExcelHandling2;
import actitimeautomation.imp1.common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUser11 extends BaseClass {
    PropertyHandling propertyHandling;
    WebDriver driver;
    UserTestPage userTestPage;

    @BeforeClass
    public void startACase() throws IOException, InterruptedException {
        propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver=super.driver;
        driver.get(propertyHandling.getProperty("actitimeURL"));
        userTestPage=new UserTestPage(driver);
    }

    @DataProvider
    public Object[][] deptData() throws IOException {
        ExcelHandling2 excelHandling2=new ExcelHandling2();
        return excelHandling2.dataFromExcel("E:\\TestData3.xlsx","Sheet3");
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginmechanism(propertyHandling.getProperty("username"), propertyHandling.getProperty("password"));
    }

    @Test(priority = 2, dataProvider = "deptData", dependsOnMethods = "login")
    public void createAUsers(Object name,Object lname, Object email)
    {  // userTestPage.createUser(name, lname, email);
        System.out.print(name.toString()+" "+lname.toString()+" "+email.toString());
    }

}
