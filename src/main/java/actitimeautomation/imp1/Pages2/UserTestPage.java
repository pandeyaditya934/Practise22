package actitimeautomation.imp1.Pages2;

import actitimeautomation.imp1.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.Key;

public class UserTestPage {
    WebDriver driver;
    CommonUtil commonUtil;
    Actions actions;
    public UserTestPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver,this);
        commonUtil =new CommonUtil(driver);
        actions=new Actions(driver);

    }

    @FindBy(xpath = "//div[@class='label' and contains(text(),'Users')]")
    WebElement userstab;
    @FindBy(xpath = "//div[@class='components_button_label' and contains(text(),'New User')]")
    WebElement newuserbutton;
    @FindBy(xpath = "id('createUserPanel_firstNameField')")
    WebElement firstname;
    @FindBy(xpath = "id('createUserPanel_lastNameField')")
    WebElement lastname;
    @FindBy(xpath="id('createUserPanel_emailField')")
    WebElement email;
    @FindBy(xpath="//div[@class='components_button_label' and contains(text(),'Save & Send Invitation')]")
    WebElement saveandsendinvitation;
    @FindBy(xpath = "(//span[text()='Close'])[1]")
    WebElement close;

    public void createUser(Object name, Object lname, Object mail)
    {   commonUtil.waitForElementClickable(userstab);
        userstab.click();
        newuserbutton.click();
        firstname.sendKeys(name.toString());
        lastname.sendKeys(lname.toString(),Keys.TAB);
        email.sendKeys(mail.toString(),Keys.ENTER);
        /*commonUtil.waitForElementToVisible(driver.findElement(By.xpath("//div[text()='Account for aditya pandey has been created.']")));
        WebElement expected=driver.findElement(By.xpath("//div[text()='Account for aditya pandey has been created.']"));
        String expecteddd=expected.toString();
        Assert.assertEquals("Account for aditya pandey has been created.",expecteddd,"invitation given");*/
        commonUtil.waitForElementClickable(close);
        close.click();

    }

}
