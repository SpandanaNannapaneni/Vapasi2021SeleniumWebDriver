package pageFactory;

import org.testng.annotations.Test;
import pageFactory.pages.HomePage;
import pageFactory.pages.LoginPage;

public class SpreeLoginLogoutTest extends SpreeBaseTest {

    @Test
    public void testLoginLogout() throws InterruptedException {


        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.openSpreeApplication();
        homePage.clickLoginFromHomePage();
        driver.navigate().refresh();
        loginPage.enterUsername("sonalpri@thoughtworks.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginFromLoginPage();
    }
}
