package actitimeautomation.imp1.Pages2;

import actitimeautomation.imp1.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TaskTestPage {

    WebDriver driver;
    CommonUtil commonUtil;
    CustTestPage custTestPage;
    ProTestPage proTestPage;
    SoftAssert softAssert;
    Actions actions;

    @FindBy(xpath = "//div[@class='item createNewTasks'and contains(text(),'New Tasks')] ")
    WebElement newtaskbutton;
    @FindBy(xpath = "//div[@id='createTasksPopup_content']/descendant::input[15]")
    WebElement taskdiscriptionarea;
    @FindBy(xpath = "//div[text()='Create Tasks']")
    WebElement createtaskbutton;
    @FindBy(xpath = "(//div[text()='Kill the Loki'])[2]/following::div[8]")
    WebElement taskactionbutton;
    @FindBy(xpath = "(//div[text()='Delete'])[4]")
    WebElement taskdeletebutton;
    @FindBy(xpath = "//span[text()='Delete permanently']")
    WebElement taskpermanentdeletebutton;
    @FindBy(xpath = "(//div[@class='atNextMount exportCPMount']/parent::div/div/descendant::div[3])[1]")
    WebElement crosssearchbox;

    public TaskTestPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver,this);
        custTestPage=new CustTestPage(driver);
        proTestPage=new ProTestPage(driver);
        commonUtil=new CommonUtil(driver);
    }

    public void createTask(String custName, String discription, String proName, String taskName) throws InterruptedException
    {   commonUtil.waitForElementClickable(custTestPage.taskButton);
        custTestPage.taskButton.click();
        commonUtil.waitForElementClickable(custTestPage.addnewbutton);
        custTestPage.addnewbutton.click();
        commonUtil.waitForElementClickable(custTestPage.newcustomer);
        custTestPage.newcustomer.click();
        commonUtil.waitForElementToVisible(custTestPage.customernametextarea);
        custTestPage.customernametextarea.sendKeys(custName);
        commonUtil.waitForElementClickable(custTestPage.discriptiontextarea);
        custTestPage.discriptiontextarea.sendKeys(discription);
        commonUtil.waitForElementClickable(custTestPage.createcustomerbutton);
        custTestPage.createcustomerbutton.click();
        Thread.sleep(3000);
        commonUtil.waitForElementClickable(custTestPage.addnewbutton);
        custTestPage.addnewbutton.click();
        proTestPage.newprojectbutton.click();
        commonUtil.waitForElementClickable(proTestPage.projectnametextarea);
        proTestPage.projectnametextarea.sendKeys(proName);
        commonUtil.waitForElementClickable(proTestPage.createprojectbutton);
        proTestPage.createprojectbutton.click();
        Thread.sleep(3000);
        commonUtil.waitForElementClickable(custTestPage.addnewbutton);
        custTestPage.addnewbutton.click();
        commonUtil.waitForElementClickable(newtaskbutton);
        newtaskbutton.click();
        commonUtil.waitForElementClickable(taskdiscriptionarea);
        taskdiscriptionarea.click();
        taskdiscriptionarea.sendKeys(taskName);
        commonUtil.waitForElementClickable(createtaskbutton);
        createtaskbutton.click();
    }

    public void veryfingTask(String custName, String discription, String proName, String taskName) throws InterruptedException
    {   Thread.sleep(3000);
        commonUtil.waitForElementClickable(custTestPage.searchboxarea);
        custTestPage.searchboxarea.click();
        custTestPage.searchboxarea.sendKeys(proName);
        //commonUtil.waitForElementClickable(driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")));
        //driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")).click();
        Thread.sleep(3000);
        Boolean taskveryficationarea=driver.findElement(By.xpath("//div[@title='Kill the Loki']")).isDisplayed();
        softAssert=new SoftAssert();
        softAssert.assertTrue(taskveryficationarea,"task is not created");
    }

    public void deleteTask(String custName, String discription, String proName, String taskName) throws InterruptedException
    {   Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='atNextMount exportCPMount']/parent::div/div/descendant::div[3])[1]")).click();
        commonUtil.waitForElementClickable(custTestPage.searchboxarea);
        custTestPage.searchboxarea.click();
        custTestPage.searchboxarea.sendKeys(proName);
        //commonUtil.waitForElementClickable(driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")));
        //driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")).click();
        commonUtil.waitForElementClickable( driver.findElement(By.xpath("//div[@title='Kill the Loki']")));
        driver.findElement(By.xpath("//div[@title='Kill the Loki']")).click();
        commonUtil.waitForElementClickable(taskactionbutton);
        taskactionbutton.click();
        commonUtil.waitForElementClickable(taskdeletebutton);
        taskdeletebutton.click();
        commonUtil.waitForElementClickable(taskpermanentdeletebutton);
        taskpermanentdeletebutton.click();
        Thread.sleep(3000);
        commonUtil.waitForElementClickable(crosssearchbox);
        crosssearchbox.click();
        commonUtil.waitForElementClickable(custTestPage.searchboxarea);
        custTestPage.searchboxarea.click();
        custTestPage.searchboxarea.sendKeys(proName);
        Thread.sleep(4000);
        commonUtil.waitForElementClickable(driver.findElement(By.xpath("//span[text()='"+proName+"']")));
        driver.findElement(By.xpath("//span[text()='"+proName+"']")).click();
        commonUtil.waitForElementClickable( driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")));
        driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")).click();
        commonUtil.waitForElementClickable(proTestPage.projectactionbutton);
        proTestPage.projectactionbutton.click();
        commonUtil.waitForElementClickable(proTestPage.projectdeletebutton);
        proTestPage.projectdeletebutton.click();
        actions=new Actions(driver);
        actions.scrollToElement(proTestPage.projectpermanentdeletebutton).click(proTestPage.projectpermanentdeletebutton).build().perform();
        Thread.sleep(4000);
        commonUtil.waitForElementClickable(driver.findElement(By.xpath("(//div[@class='atNextMount exportCPMount']/parent::div/div/descendant::div[3])[1]")));
        driver.findElement(By.xpath("(//div[@class='atNextMount exportCPMount']/parent::div/div/descendant::div[3])[1]")).click();
        commonUtil.waitForElementClickable(custTestPage.searchboxarea);
        custTestPage.searchboxarea.sendKeys(custName);
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//div[@class='unfilteredContainer']/following::span[text()='"+custName+"'])[1]")).click();
        commonUtil.waitForElementClickable(custTestPage.editbuttonfordelete);
        custTestPage.editbuttonfordelete.click();
        commonUtil.waitForElementClickable(custTestPage.actionbuttondelete);
        custTestPage.actionbuttondelete.click();
        commonUtil.waitForElementClickable(custTestPage.deletebutton);
        custTestPage.deletebutton.click();
        actions.scrollToElement(driver.findElement(By.xpath("//span[text()='Delete permanently']"))).click( driver.findElement(By.xpath("//span[text()='Delete permanently']"))).build().perform();
    }
}
