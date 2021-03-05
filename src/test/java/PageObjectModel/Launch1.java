package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Launch1 {
    @Test
    public void verifyInvalidLoginMessage(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.get("https://spree-vapasi.herokuapp.com/");
        //Locating the Login button and clicking on it
        driver.findElement(By.id("link-to-login")).click();

        //Locating the username & password and passing the credentials
        driver.findElement(By.id("spree_user_email")).sendKeys("sonalpri@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("password123");

        //Click on the login button
        driver.findElement(By.name("commit")).click();
        //Logout------
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.findElement(By.linkText("Logout")).click();
        //Close driver instance
        driver.quit();
    }
}

