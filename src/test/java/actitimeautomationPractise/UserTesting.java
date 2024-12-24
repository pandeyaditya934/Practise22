package actitimeautomationPractise;

import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.PropertyHandling;
import actitimeautomation.imp1.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTesting extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;

    @BeforeClass
    public void beforeClass() throws IOException
    {   propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
    }

    @Test(priority = 1)
    public void Login() throws IOException
    {   driver.get(propertyHandling.getProperty("actitimeURL"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(propertyHandling.getProperty("username"),propertyHandling.getProperty("password"));
    }
}
