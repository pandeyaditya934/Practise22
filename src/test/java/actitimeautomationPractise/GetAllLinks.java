package actitimeautomationPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GetAllLinks {
    public static void main (String[] args) throws IOException
    {   WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        List<WebElement>alllinks=driver.findElements(By.tagName("a"));
        System.out.println(alllinks.size());
        for(WebElement printLinks:alllinks)
        {   String linksname=printLinks.getAttribute("href");
            if(linksname !=null)
            {   URL url=new URL(linksname);
                URLConnection connection=url.openConnection();
                HttpURLConnection httpURLConnection=(HttpURLConnection) connection;
                httpURLConnection.connect();
                int statuscode=httpURLConnection.getResponseCode();
                if(statuscode>299)
                {   System.out.println(statuscode+" and there "+linksname);
                }
            }
        }
    }
}
