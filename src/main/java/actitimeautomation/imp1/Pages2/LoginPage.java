package actitimeautomation.imp1.Pages2;

import actitimeautomation.imp1.common.CommonUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLOutput;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement loginplace;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordplace;
    @FindBy(xpath = "//a[@id='loginButton']")
            WebElement loginbutton;
    @FindBy(xpath = "//span[text()='Username or Password is invalid. Please try again.']")
            WebElement erromessagelogin;
    CommonUtil commonUtil;

    public LoginPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver,this);
        commonUtil=new CommonUtil(driver);
    }
    public void loginmechanism(String username1, String password1) throws InterruptedException
    {   Thread.sleep(5000);
        loginplace.click();
        loginplace.sendKeys(username1);
        commonUtil.waitForElementClickable(passwordplace);
        passwordplace.click();
        passwordplace.sendKeys(password1);
        commonUtil.waitForElementClickable(loginbutton);
        loginbutton.click();
       /* commonUtil.waitForElementToVisible(erromessagelogin);
        String actualresult=erromessagelogin.getText();
        String expectedresult="Username or Password is invalid. Please try again.";
        Assert.assertEquals(actualresult,expectedresult,"no its not working");
        System.out.println("yes its done");*/
    }

}
