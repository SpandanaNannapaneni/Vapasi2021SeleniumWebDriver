package com.vapasi2021.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {
    public static void takeScreenShot(WebDriver driver) throws IOException {
        String timeStamp;
        File screenShotName;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        screenShotName = new File(System.getProperty("user.dir")+"/"+timeStamp+".png");
        FileHandler.copy(scrFile, screenShotName);

        String  filePath = screenShotName.toString();
        System.out.println(filePath);
        Reporter.log("<img src='"+filePath+"'");
    }
}
