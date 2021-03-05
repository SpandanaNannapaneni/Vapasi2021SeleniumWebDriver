package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementExample1 {
    @Test
    public void verifyInvalidLoginMessage() throws InterruptedException {
        WebDriver driver = null;
        WebElement usernameTextBox;
        try {
            System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://spree-vapasi.herokuapp.com/");

            //Locating the Login button and clicking on it
            driver.findElement(By.id("link-to-login")).click();

            //Locating the username & password and passing the credentials
            usernameTextBox = driver.findElement(By.id("spree_user_email"));   //stores username address in @a1
            System.out.println("address of unTextBox before refresh: " + usernameTextBox + " : " + usernameTextBox.getText());

            driver.navigate().refresh();  //refresh and username get new address x1

            usernameTextBox.sendKeys("sonalpri@thoughtworks.com");  //try to enter admin using old address a1
            System.out.println("address of unTextBox after refresh: " + usernameTextBox + " : " + usernameTextBox.getText());
        } catch (Exception e) {
            System.out.println("Inside Catch" + e);

        } finally {
            driver.quit();
        }


    }
}
