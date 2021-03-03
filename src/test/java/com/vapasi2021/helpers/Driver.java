package com.vapasi2021.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Driver {
    public static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/spandana/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("spandana@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("spd1245678");
        driver.findElement(By.cssSelector("#new_spree_user > p:nth-child(5) > input")).click();
        WebElement error = driver.findElement(By.cssSelector("#content > div.alert.alert-error"));
        Assert.assertEquals(error.getText(), "Invalid email or password.");

        driver.quit();
    }


    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/spandana/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com");
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}
