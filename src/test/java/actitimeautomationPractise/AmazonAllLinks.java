package actitimeautomationPractise;

import actitimeautomation.imp1.common.BaseClass;
import actitimeautomation.imp1.common.CommonUtil;
import actitimeautomation.imp1.common.PropertyHandling;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class AmazonAllLinks extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;
    CommonUtil commonUtil;

    @BeforeClass
    public void Starting() throws IOException {
        propertyHandling=new PropertyHandling();
        launchBrowser(propertyHandling.getProperty("browser"));
        driver=super.driver;
        commonUtil=new CommonUtil(driver);
        driver.get("https://www.amazon.in/");
    }
    @Test
    public void takeAllLinks() throws InterruptedException, IOException
    {  Thread.sleep(6000);
        List<WebElement> tagelement=driver.findElements(By.tagName("a"));
        System.out.println(tagelement.size());
        for(WebElement element:tagelement)
        {   String values=element.getAttribute("href");
            if(values!=null)
            {   System.out.println(values);
                URL url=new URL(values);
                URLConnection connection=url.openConnection();
                HttpURLConnection httpURLConnection=(HttpURLConnection) connection;
                httpURLConnection.connect();
                int statusCode=httpURLConnection.getResponseCode();
                if(statusCode>299)
                {
                    System.out.println(statusCode+" "+values);
                }
            }
        }
    }
}
