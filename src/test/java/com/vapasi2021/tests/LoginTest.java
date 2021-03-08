package com.vapasi2021.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginSuccessMessage() {
        loginPage.login("spandana@thoughtworks.com", "spd12345678");
        String successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']")).getText();
        assertEquals(successMessage, "Logged in successfully");
    }

    @Test
    public void verifyInvalidLoginMessage() {
        loginPage.login("spd@gmail.com", "1234567");
        String error = driver.findElement(By.cssSelector("div[class='alert alert-error']")).getText();
        assertEquals(error, "Invalid email or password.");
    }

    @Test
    public void verifyLogoutMessage() {
        loginPage.login("spandana@thoughtworks.com", "spd12345678");
        loginPage.logout();
        driver.findElement(By.cssSelector("div[class='alert alert-notice']")).isDisplayed();
        assertEquals(driver.findElement(By.cssSelector("div[class='alert alert-notice']")).getText(), "Signed out successfully.");
    }
}
