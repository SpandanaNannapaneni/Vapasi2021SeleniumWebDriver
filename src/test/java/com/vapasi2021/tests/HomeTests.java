package com.vapasi2021.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest {


    @Test
    public void verifySearch() {
        homePage.search("Baseball");
        Assert.assertTrue(driver.findElement(By.partialLinkText("Ruby on Rails Baseball Jersey")).isDisplayed());
    }

    @Test
    public void verifyAddToCart() {
        loginPage.login("spandana@thoughtworks.com", "spd12345678");
        driver.findElement(By.cssSelector("div[class='alert alert-success']")).isDisplayed();
        homePage.addProductToCart("Ruby on Rails Tote");
        homePage.openCart();
        homePage.loadCartPage();
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Ruby on Rails Tote']")).isDisplayed());
    }


}
