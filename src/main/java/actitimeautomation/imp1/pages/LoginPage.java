package actitimeautomation.imp1.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameinput;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordinput;
    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement clickLoginButton;

 public LoginPage(WebDriver driver) throws IOException {
     this.driver=driver;
     PageFactory.initElements(driver,this);
 }

 public void login(String username, String password)
 {  usernameinput.click();
    usernameinput.sendKeys(username);
    passwordinput.click();
    passwordinput.sendKeys(password);
    clickLoginButton.click();
 }


}
