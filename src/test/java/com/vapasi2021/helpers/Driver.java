package com.vapasi2021.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Driver {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/spandana/Downloads/chromedriver");
        Driver.driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @BeforeMethod
    public void setURL() {
        driver.manage().deleteAllCookies();
        driver.get("https://spree-vapasi.herokuapp.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}