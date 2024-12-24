package actitimeautomation.imp1.Pages2;

import actitimeautomation.imp1.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ProTestPage {
    WebDriver driver;
    CustTestPage custTestPage;
    CommonUtil commonUtil;
    Actions actions;

    @FindBy(xpath = "//div[text()='New Project']")
    WebElement newprojectbutton;
    @FindBy(xpath = "(//input[@placeholder='Enter Project Name'])[2]")
    WebElement projectnametextarea;
    @FindBy(xpath = "//div[text()='Create Project']")
    WebElement createprojectbutton;
    @FindBy(xpath = "//div[@class='taskManagement_projectPanel']/descendant::div[14]")
    WebElement projectactionbutton;
    @FindBy(xpath = "(//div[text()='Delete'])[3]")
    WebElement projectdeletebutton;
    @FindBy(xpath = "//span[text()='Delete permanently']")
    WebElement projectpermanentdeletebutton;

    public ProTestPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver,this);
        custTestPage=new CustTestPage(driver);
        commonUtil=new CommonUtil(driver);
    }

    public void creatingProject(String custName, String discription, String proName) throws InterruptedException
    {   custTestPage.createCustomer(custName, discription);
        Thread.sleep(3000);
        custTestPage.addnewbutton.click();
        newprojectbutton.click();
        commonUtil.waitForElementClickable(projectnametextarea);
        projectnametextarea.sendKeys(proName);
        commonUtil.waitForElementClickable(createprojectbutton);
        createprojectbutton.click();
    }

    public void veryfingProject(String custName, String discription, String proName) throws InterruptedException
    {   commonUtil.waitForElementClickable(custTestPage.searchboxarea);
        custTestPage.searchboxarea.click();
        custTestPage.searchboxarea.sendKeys(proName);
        SoftAssert softAssert=new SoftAssert();
        Thread.sleep(4000);
        Boolean projectRepresent=driver.findElement(By.xpath("//span[text()='"+proName+"']")).isDisplayed();
        softAssert.assertTrue(projectRepresent,"project not created");
        Thread.sleep(4000);
        Boolean assigntocustomer=driver.findElement(By.xpath("(//span[text()='CaptainAmerica']/ancestor::div/descendant::div[contains(text(),'"+custName+"')])[2]")).isDisplayed();
        softAssert.assertTrue(assigntocustomer,"not assign to the right customer");
    }

    public void deleteProject(String custName, String discription, String proName) throws InterruptedException
    {   commonUtil.waitForElementClickable(driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")));
        driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")).click();
        commonUtil.waitForElementClickable(projectactionbutton);
        projectactionbutton.click();
        commonUtil.waitForElementClickable(projectdeletebutton);
        projectdeletebutton.click();
        actions=new Actions(driver);
        actions.scrollToElement(projectpermanentdeletebutton).click(projectpermanentdeletebutton).build().perform();
        commonUtil.waitForElementClickable(driver.findElement(By.xpath("(//div[@class='atNextMount exportCPMount']/parent::div/div/descendant::div[3])[1]")));
        driver.findElement(By.xpath("(//div[@class='atNextMount exportCPMount']/parent::div/div/descendant::div[3])[1]")).click();
        commonUtil.waitForElementClickable(custTestPage.searchboxarea);
        custTestPage.searchboxarea.sendKeys(custName);
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//div[@class='unfilteredContainer']/following::span[text()='"+custName+"'])[1]")).click();
        commonUtil.waitForElementClickable(custTestPage.editbuttonfordelete);
        custTestPage.editbuttonfordelete.click();
        Thread.sleep(4000);
        custTestPage.actionbuttondelete.click();
        commonUtil.waitForElementClickable(custTestPage.deletebutton);
        custTestPage.deletebutton.click();
        actions.scrollToElement(driver.findElement(By.xpath("//span[text()='Delete permanently']"))).click( driver.findElement(By.xpath("//span[text()='Delete permanently']"))).build().perform();
    }
}
