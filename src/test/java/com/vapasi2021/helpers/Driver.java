package com.vapasi2021.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Driver {
    public static WebDriver driver;
    public static WebDriverWait wait;

//    public static WebDriver getDriver() {
//        return driver;
//    }


    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/spandana/Downloads/chromedriver");
        Driver.driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @BeforeMethod
    public void setURL() throws IOException {
        driver.manage().deleteAllCookies();
        driver.get("https://spree-vapasi.herokuapp.com");
//        Utils.takeScreenShot(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}