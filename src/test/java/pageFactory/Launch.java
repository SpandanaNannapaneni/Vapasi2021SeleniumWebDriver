package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Launch {
    @Test
    public void verifyInvalidLoginMessage() {
    System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
    }
}
/*

1. take a @test class and add locators there in test class for execution
2. Seperate those locators in respective page: explain what happens if some id has changed [POM]
3. Single responsibility // kapil
4. Page Factory [pagefactory.initElement()]
*/

