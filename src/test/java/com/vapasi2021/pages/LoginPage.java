package com.vapasi2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void login(String emailId, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("link-to-login")));
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(emailId);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name ='commit']")).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout")));
        driver.findElement(By.partialLinkText("Logout")).click();
    }

}
