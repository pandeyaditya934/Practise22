package actitimeautomationPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingCss {
    public static void main(String []args) throws InterruptedException
    {   WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        driver.manage().window().maximize();
    }
}
