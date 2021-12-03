package saucedemoremove;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import saucedemoremove.pages.CartPage;
import saucedemoremove.pages.LoginPage;
import saucedemoremove.pages.StorePage;

import java.util.concurrent.TimeUnit;

public class StorePageBase {
    CartPage cartPage;
    LoginPage loginPage;
    StorePage storePage;

    WebDriver driver;
    String URL = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";
    String productName = "Sauce Labs Backpack";
    String productPrice = "$29.99";


    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        loginPage = new LoginPage(driver);
    }

    @After
    public void driverQuit() {
        driver.quit();
    }

}
