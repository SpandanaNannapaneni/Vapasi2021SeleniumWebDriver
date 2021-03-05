package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for login button
    By LoginBtn = By.id("link-to-login");
    By LogoutBtn = By.linkText("Logout");

    //Method to click login button
    public void clickLogin()
    {
        driver.findElement(LoginBtn).click();
    }
    public void clickLogout() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.findElement(LogoutBtn).click();
    }

}
