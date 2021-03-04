package com.vapasi2021.tests;

import com.vapasi2021.helpers.Driver;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Tests extends Driver {

    public String emailId;
    public String password;

    @Test
    public void verifyInvalidLoginMessage() {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("spandana@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("acdeek");
        driver.findElement(By.cssSelector("input[name ='commit']")).isDisplayed();
        driver.findElement(By.cssSelector("input[name ='commit']")).click();
        String error = driver.findElement(By.cssSelector("div[class='alert alert-error']")).getText();
        Assert.assertEquals(error, "Invalid email or password.");
    }

    @Test
    public void verifySearch() {
        driver.findElement(By.id("keywords")).sendKeys("Baseball");
        driver.findElement(By.cssSelector("input[class='btn btn-success']"));
        driver.findElement(By.linkText("Ruby on Rails Baseball Jersey")).isDisplayed();

    }


    public void login(String emailId, String password) {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(emailId);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name ='commit']")).click();
    }

    @Test
    public void verifyLoginSuccessMessage() {
        //arrange
        emailId = "spandana@thoughtworks.com";
        password = "spd12345678";
        //act
        login(emailId, password);
        String successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']")).getText();
        //assert
        Assert.assertEquals(successMessage, "Logged in successfully");
    }
}
