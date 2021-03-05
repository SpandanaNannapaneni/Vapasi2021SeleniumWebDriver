package pageFactory.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    public void openSpreeApplication() {
        driver.get("https://spree-vapasi.herokuapp.com/");
    }
}
