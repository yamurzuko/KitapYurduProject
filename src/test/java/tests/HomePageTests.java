package tests;

import driver.BaseTest;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class HomePageTests extends BaseTest {

    @Test
    public void testHomePageActions(){

        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
        getHomePage().actionsHomePage();
        getHomePage().addProductToCart();
    }
}
