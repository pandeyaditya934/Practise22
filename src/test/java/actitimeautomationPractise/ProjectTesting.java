package actitimeautomationPractise;

import actitimeautomation.imp1.Pages2.ProTestPage;
import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.PropertyHandling;
import actitimeautomation.imp1.common.TestListeners;
import actitimeautomation.imp1.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestListeners.class)
public class ProjectTesting extends BaseClass
{   WebDriver driver;
    PropertyHandling propertyHandling;
    ProTestPage proTestPage;

    @BeforeClass
    public void openingBrowser() throws IOException {
        propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver=super.driver;
    }

    @DataProvider
    public Object[][]testData()
    {   Object [][] obj=new Object [][]
        {
            {"Marvel","First avenger","CaptainAmerica"}
        };return obj;
    }

    @Test(priority = 1 )
    public void login() throws IOException
    {   driver.get(propertyHandling.getProperty("actitimeURL"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(propertyHandling.getProperty("username"),propertyHandling.getProperty("password"));
    }

    @Test(priority = 2, dataProvider = "testData")
    public void createProject(Object custname, Object discription, Object proname) throws InterruptedException
    {   proTestPage=new ProTestPage(driver);
        proTestPage.creatingProject(custname.toString(),discription.toString(),proname.toString());
    }

    @Test(priority = 3, dataProvider = "testData", dependsOnMethods = "createProject")
    public void veryfyProject(Object custname, Object discription, Object proname) throws InterruptedException
    { proTestPage.veryfingProject(custname.toString(),discription.toString(),proname.toString());
    }

    @Test(priority = 4,dependsOnMethods = "veryfyProject",dataProvider = "testData")
    public void deleteProject(Object custname, Object discription, Object proname) throws InterruptedException
    {   proTestPage.deleteProject(custname.toString(),discription.toString(),proname.toString());
    }

    @AfterClass
    public void exit()
    {driver.quit();}
}
