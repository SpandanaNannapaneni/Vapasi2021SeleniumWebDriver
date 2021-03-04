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
        driver.get("https://demoqa.com");
    }
}
