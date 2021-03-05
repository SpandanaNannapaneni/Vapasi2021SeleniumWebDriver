package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="spree_user_email")
    private WebElement uName;

    @FindBy(id="spree_user_password")
    private WebElement uPassword;

    @FindBy(name="commit")
    private WebElement loginBtnFromLoginPage;


    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    //Method to enter username
    public void enterUsername(String userName) {
      uName.sendKeys(userName);
    }

    //Method to enter password
    public void enterPassword(String userPassword)
    {
       uPassword.sendKeys(userPassword);
    }

    //Method to click on Login button
    public void clickLoginFromLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        loginBtnFromLoginPage.click();

    }
}
