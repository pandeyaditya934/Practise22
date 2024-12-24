package actitimeautomationPractise;

import actitimeautomation.imp1.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class Practisehandling {
    public static void main (String []args)
    {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        String primarywindow=driver.getWindowHandle();
        System.out.println(primarywindow);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.flipkart.com/");
        String secondarywindow=driver.getWindowHandle();
        System.out.println(secondarywindow);
        Set<String> uniqueIdes=driver.getWindowHandles();
        System.out.println(uniqueIdes);
        driver.switchTo().window(primarywindow);
        Actions actions=new Actions(driver);
        CommonUtil commonUtil=new CommonUtil(driver);
        //commonUtil.waitForElementClickable(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")));
        //actions.click(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).sendKeys("Books").build().perform();
        Select select=new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> alloptions=select.getOptions();
        for(WebElement values : alloptions )
        {   String textName=values.getText();
            if(textName.equals("Baby"))
            {   select.selectByVisibleText(textName);
                System.out.println("yes it is a books");
            }else{  System.out.println("no it is not a book");
            }
            break;
        }

    }
}
