package com.vapasi2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void search(String productToBeSearched) {
        driver.findElement(By.id("keywords")).sendKeys(productToBeSearched);
        driver.findElement(By.cssSelector("input[class='btn btn-success']"));
    }

    public void addProductToCart(String NameOfTheProduct) {
        driver.findElement(By.linkText(NameOfTheProduct)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("link-to-cart")));
        driver.findElement(By.id("link-to-cart")).click();
    }

    public void loadCartPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("h1")).isDisplayed();
    }
}
