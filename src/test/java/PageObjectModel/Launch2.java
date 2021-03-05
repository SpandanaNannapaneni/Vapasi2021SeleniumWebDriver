package PageObjectModel;

import PageObjectModel.pages.HomePage;
import PageObjectModel.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Launch2 {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.get("https://spree-vapasi.herokuapp.com/");
    }

    @Test
    public void verifyInvalidLoginMessage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        //Locating the username & password and passing the credentials
        loginPage.enterUsername("sonalpri@thoughtworks.com");
        loginPage.enterPassword("password123");
        //Click on the login button
        loginPage.clickLogin();
        homePage.clickLogout();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

/*    @Test
   public void testLoginLogout(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("sonalpri@thoughtworks.com");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();

    }*/
}


