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

public class CustTestPage {
    WebDriver driver;
    CommonUtil commonUtil;
    @FindBy(xpath = "//div[@id='container_tasks']/following::div")
    WebElement taskButton;
    @FindBy(xpath = "//div[@class='title ellipsis']")
    WebElement addnewbutton;
    @FindBy(xpath = "//div[@class='item createNewCustomer']")
    WebElement newcustomer;
    @FindBy(xpath = "//div[@class='customerNameDiv']/input")
    WebElement customernametextarea;
    @FindBy(xpath = "//div[@class='inputContainer']/textarea[@placeholder='Enter Customer Description']")
    WebElement discriptiontextarea;
    @FindBy(xpath = "//div[text()='Create Customer']")
    WebElement createcustomerbutton;

    @FindBy(xpath = "//div[@class='searchFieldContainer']/descendant::input")
    WebElement searchboxarea;
    @FindBy(xpath = "//div[@id='taskListBlock']/descendant::div[7]")
    WebElement editbuttonfordelete;
    @FindBy(xpath = "//div[@class='customerNamePlaceHolder']/following::div[5]")
    WebElement actionbuttondelete;
    @FindBy(xpath = "(//div[text()='Delete'])[2]")
    WebElement deletebutton;

    public CustTestPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver,this);
        commonUtil=new CommonUtil(driver);
    }

    public void createCustomer(String custName, String discritpiontext)
    {   commonUtil.waitForElementClickable(taskButton);
        taskButton.click();
        commonUtil.waitForElementClickable(addnewbutton);
        addnewbutton.click();
        commonUtil.waitForElementClickable(newcustomer);
        newcustomer.click();
        commonUtil.waitForElementToVisible(customernametextarea);
        customernametextarea.sendKeys(custName);
        commonUtil.waitForElementClickable(discriptiontextarea);
        discriptiontextarea.sendKeys(discritpiontext);
        commonUtil.waitForElementClickable(createcustomerbutton);
        createcustomerbutton.click();
    }

    public void veryfingCustomer(String custName) throws InterruptedException {
        commonUtil.waitForElementClickable(searchboxarea);
        searchboxarea.sendKeys(custName);
        Thread.sleep(5000);
        Boolean customernameveryfied=driver.findElement(By.xpath("//div[@class='unfilteredContainer']/following::span[text()='"+custName+"']")).isDisplayed();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(customernameveryfied,"true","customer is created");
    }

    public void deleteCustomer(String custName) throws InterruptedException
    {   driver.findElement(By.xpath("//div[@class='unfilteredContainer']/following::span[text()='"+custName+"']")).click();
        commonUtil.waitForElementClickable(editbuttonfordelete);
        editbuttonfordelete.click();
        commonUtil.waitForElementClickable(actionbuttondelete);
        actionbuttondelete.click();
        commonUtil.waitForElementClickable(deletebutton);
        deletebutton.click();
        Actions actions=new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//span[text()='Delete permanently']"))).click( driver.findElement(By.xpath("//span[text()='Delete permanently']"))).build().perform();
    }
}
