package driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class BaseTest {

    public static WebDriver driver;

    private LoginPage loginPage;

    private ProductPage productPage;

    private HomePage homePage;

    private CartPage cartPage;

    public LoginPage getLoginPage(){
        if (loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ProductPage getProductPage(){
        if (productPage == null){
            productPage = new ProductPage();
        }
        return productPage;
    }

    public HomePage getHomePage(){
        if (homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public CartPage getCartPage(){
        if (cartPage == null){
            cartPage = new CartPage();
        }
        return cartPage;
    }

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-translate");

        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.kitapyurdu.com/");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        loginPage = null;
        productPage = null;
        homePage = null;
        cartPage = null;
    }
}
