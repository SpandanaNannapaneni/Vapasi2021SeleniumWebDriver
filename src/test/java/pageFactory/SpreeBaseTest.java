package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class SpreeBaseTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
