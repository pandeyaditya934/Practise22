package actitimeautomationPractise;

import actitimeautomation.imp1.Pages2.CustTestPage;
import actitimeautomation.imp1.Pages2.ProTestPage;
import actitimeautomation.imp1.Pages2.TaskTestPage;
import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.CommonUtil;
import actitimeautomation.imp1.common.PropertyHandling;
import actitimeautomation.imp1.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TaskTesting extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;
    TaskTestPage taskTestPage;

    @BeforeClass
    public void beforeClass() throws IOException
    {   propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver=super.driver;
        taskTestPage=new TaskTestPage(driver);
    }

    @DataProvider
    public Object[][]testData()
    {   Object [][] obj=new Object [][]
            {
                    {"Marvel","First avenger","CaptainAmerica","Kill the Loki"}
            };return obj;
    }

    @Test(priority = 1 )
    public void login() throws IOException
    {   driver.get(propertyHandling.getProperty("actitimeURL"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(propertyHandling.getProperty("username"),propertyHandling.getProperty("password"));
    }

    @Test(priority = 2,dataProvider = "testData")
    public void createTasks(Object custName, Object discription, Object proName, Object taskName) throws InterruptedException
    {   taskTestPage.createTask(custName.toString(), discription.toString(), proName.toString(), taskName.toString());
    }

    @Test(priority = 3, dependsOnMethods = "createTasks", dataProvider = "testData")
    public void taskVeryfication(Object custName, Object discription, Object proName, Object taskName) throws InterruptedException
    {   taskTestPage.veryfingTask(custName.toString(), discription.toString(), proName.toString(), taskName.toString());
    }

    @Test(priority = 4, dependsOnMethods = "taskVeryfication", dataProvider = "testData")
    public void taskDelete(Object custName, Object discription, Object proName, Object taskName) throws InterruptedException
    {   taskTestPage.deleteTask(custName.toString(), discription.toString(), proName.toString(), taskName.toString());
    }

    @AfterClass
    public void exit()
    {driver.quit();}
}
