package com.vapasi2021.tests;

import com.vapasi2021.helpers.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Tests extends Driver {
    @Test
    public void verifyInvalidLoginMessage(){
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("spandana@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("acdeek");
        driver.findElement(By.cssSelector("#new_spree_user > p:nth-child(5) > input")).click();
        String error = driver.findElement(By.cssSelector("#content > div.alert.alert-error")).getText();
        Assert.assertEquals(error,"Invalid email or password.");
    }
    @Test
    public void verifyLoginSuccessMessage(){
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("spandana@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("spd12345678");
        driver.findElement(By.cssSelector("#new_spree_user > p:nth-child(5) > input")).click();
        String sucessMessage = driver.findElement(By.cssSelector("#content > div.alert.alert-success")).getText();
        Assert.assertEquals(sucessMessage,"Logged in successfully");
    }
    @Test
    public void verifySearch(){
        driver.findElement(By.id("keywords")).sendKeys("Baseball");
        driver.findElement(By.cssSelector("#search-bar > form > input.btn.btn-success"));
        driver.findElement(By.cssSelector("#product_6 > div > div.panel-body.text-center.product-body > a")).isDisplayed();

    }
}
