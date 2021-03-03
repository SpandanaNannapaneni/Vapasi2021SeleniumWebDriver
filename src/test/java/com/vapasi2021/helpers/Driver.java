package com.vapasi2021.helpers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        String error = driver.findElement(By.cssSelector("#content > div.alert.alert-error")).getText();
        Assert.assertEquals(error,"Invalid email or password.");

        driver.quit();
    }



@Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/spandana/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com");
    }
@After
    public void quitDriver(){
        driver.quit();
    }

}