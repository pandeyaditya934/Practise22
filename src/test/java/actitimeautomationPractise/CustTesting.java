package actitimeautomationPractise;

import actitimeautomation.imp1.Pages2.CustTestPage;
import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.PropertyHandling;
import actitimeautomation.imp1.common.TestListeners;
import actitimeautomation.imp1.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestListeners.class)
public class CustTesting extends BaseClass {
    public static WebDriver driver;
    PropertyHandling propertyHandling;
    CustTestPage custTestPage;

    @BeforeClass
    public void openingBrowser() throws IOException {
        propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver=super.driver;
    }
    @DataProvider
    public Object[][] testData()
    {   Object [][] obj=new Object[][]
            {
                    {"Marvel","Its a Hollywood industry series belongs to Marvel production"}
            };
        return obj;
    }

    @Test(priority = 1 )
    public void login() throws IOException
    {   driver.get(propertyHandling.getProperty("actitimeURL"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(propertyHandling.getProperty("username"),propertyHandling.getProperty("password"));
    }

    @Test(priority = 2, dataProvider = "testData")
    public void creatingCustomer(Object customerName,Object discriptiontext)
    {   custTestPage=new CustTestPage(driver);
        custTestPage.createCustomer(customerName.toString(),discriptiontext.toString());
    }

    @Test(dependsOnMethods = "creatingCustomer", dataProvider = "testData")
    public void verifyCustomer(Object customerName, Object discriptiontext) throws InterruptedException
    {   custTestPage.veryfingCustomer(customerName.toString());
    }

    @Test(dependsOnMethods = "verifyCustomer",dataProvider = "testData")
    public void deleteTheCustomer(Object customerName, Object discriptiontext) throws InterruptedException
    {   custTestPage.deleteCustomer(customerName.toString());
    }

    @AfterClass
    public void exit()
    {driver.quit();}
}