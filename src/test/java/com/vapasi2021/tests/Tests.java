package com.vapasi2021.tests;

import com.vapasi2021.helpers.Driver;
import com.vapasi2021.pages.LoginPage;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Tests extends Driver {

    public String emailId;
    public String password;
    LoginPage loginPage;


    @Test
    public void verifyInvalidLoginMessage() {
        emailId = "spd@gmail.com";
        password = "1234567";
        login(emailId, password);
        String error = driver.findElement(By.cssSelector("div[class='alert alert-error']")).getText();
        assertEquals(error, "Invalid email or password.");
    }

    @Test
    public void verifySearch() {
        driver.findElement(By.id("keywords")).sendKeys("Baseball");
        driver.findElement(By.cssSelector("input[class='btn btn-success']"));
        driver.findElement(By.linkText("Ruby on Rails Baseball Jersey")).isDisplayed();
    }



    @Test
    public void verifyAddToCart() {
        //Arrange
        emailId = "spandana@thoughtworks.com";
        password = "spd12345678";
        //Act
        loginPage.login(emailId, password);
        driver.findElement(By.cssSelector("div[class='alert alert-success']")).isDisplayed();
        addProductToCart("Ruby on Rails Tote");
        openCart();
        //Assert
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("h1")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Ruby on Rails Tote']")).isDisplayed());
    }



    public void login(String emailId, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("link-to-login")));
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(emailId);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name ='commit']")).click();
    }

    private void addProductToCart(String NameOfTheProduct) {
        driver.findElement(By.linkText(NameOfTheProduct)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    private void openCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("link-to-cart")));
        driver.findElement(By.id("link-to-cart")).click();
    }

    private void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout")));
        driver.findElement(By.partialLinkText("Logout")).click();
    }


}
