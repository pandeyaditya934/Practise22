package actitimeautomationPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintPriceName {
    public static void main(String []args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("harry poter books");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(4000);
        List<WebElement> name=driver.findElements(By.xpath("//div[@data-index='3']/descendant::span[3]"));
        List<WebElement> price=driver.findElements(By.xpath("//div[@data-index='3']/descendant::span[@class='a-price-whole'][1]"));
        if(name.size() == price.size())
        {   for(int i=0; i<price.size(); i++)
            {   WebElement prises=price.get(i);
                String priceofbook=prises.getText();
                WebElement books=name.get(i);
                String nameofbook=books.getText();
                System.out.println(nameofbook +" and "+ priceofbook);
            }
        }
    }
}
