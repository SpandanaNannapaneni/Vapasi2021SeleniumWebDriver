package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(id = "link-to-login")
    private WebElement loginBtn;

    @FindBy(linkText = "Logout")
    private WebElement logoutBtn;

    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }
    public void clickLoginFromHomePage(){
        loginBtn.click();
    }
    public void clickLogoutFromHomePage(){

        logoutBtn.click();
    }

   /* public void openSpreeApplication() {
        driver.get("https://spree-vapasi.herokuapp.com/");
    }*/
}
