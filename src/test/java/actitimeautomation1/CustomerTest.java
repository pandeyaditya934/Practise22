package actitimeautomation1;

import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.CommonUtil;
import actitimeautomation.imp1.common.LoginSetup;
import actitimeautomation.imp1.common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerTest  extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;
    CommonUtil commonUtil;
    public CustomerTest() throws IOException
    {   propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver = super.driver;
        driver.navigate().to(propertyHandling.getProperty("actitimeURL"));
        LoginSetup loginSetup=new LoginSetup(driver);
        loginSetup.loginMethod(propertyHandling.getProperty("username"),propertyHandling.getProperty("password"));
         commonUtil=new CommonUtil(driver);

    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div")).click();
        String Name="aditya";
        Assert.assertEquals("aditya",Name,"pandey");
    }
}
