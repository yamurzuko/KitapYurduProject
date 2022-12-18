package tests;

import driver.BaseTest;
import org.junit.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class CartPageTests extends BaseTest {

    @Test
    public void testCartActions(){

        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
        getHomePage().actionsHomePage();
        getHomePage().addProductToCart();
        getCartPage().cartActions();
    }
}
