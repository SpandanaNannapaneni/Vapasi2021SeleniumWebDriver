package com.vapasi2021.tests;

import com.vapasi2021.helpers.Driver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


    @Test
    public void verifyLoginSuccessMessage() {
        //arrange
        emailId = "spandana@thoughtworks.com";
        password = "spd12345678";
        //act
        login(emailId, password);
        //assert
        String successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']")).getText();
        Assert.assertEquals(successMessage, "Logged in successfully");
    }

    @Test
    public void verifyAddToCart() {
        //arrange
        emailId = "spandana@thoughtworks.com";
        password = "spd12345678";
        //act
        login(emailId, password);
        driver.findElement(By.cssSelector("div[class='alert alert-success']")).isDisplayed();
        addProductToCart("Ruby on Rails Tote");
        openCart();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h1"))));
        driver.findElement(By.cssSelector("h1")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Ruby on Rails Tote']")).isDisplayed());
    }


    private void login(String emailId, String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("link-to-login"))));
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(emailId);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name ='commit']")).click();
    }

    private void addProductToCart(String NameOfTheProduct) {
        driver.findElement(By.linkText(NameOfTheProduct)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-button"))));
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    private void openCart() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("link-to-cart"))));
        driver.findElement(By.id("link-to-cart")).click();
    }
}
